package com.example.howmuch.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.howmuch.Add_itemData
import com.example.howmuch.R
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_mylist.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

class addFragment : Fragment() {
    private val OPEN_GALLERY = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_add, container, false)

        return root
    }

    private var currentImageUri: Uri? = null
    private lateinit var database: DatabaseReference
    private var storageReference: StorageReference? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //database = FirebaseDatabase.getInstance().reference
        storageReference = FirebaseStorage.getInstance().reference

        add_item_btn.setOnClickListener {
            upload()
        }

        add_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, OPEN_GALLERY)
        }
    }

    private fun upload() {
        Log.d("pics", currentImageUri.toString())
        if(currentImageUri != null) {
            val ref = storageReference?.child("uploads/" + UUID.randomUUID().toString())
            val uploadTask = ref?.putFile(currentImageUri!!)

            val urlTask =
                uploadTask?.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let {
                            throw it
                        }
                    }
                    return@Continuation ref.downloadUrl
                })?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val downloadUri = task.result
                        addUploadRecordToDb(downloadUri.toString())
                    } else {
                        Toast.makeText(fragmentContainer.context,  "저장을 실패했습니다.", Toast.LENGTH_LONG).show()
                    }


                }?.addOnFailureListener{
                    Toast.makeText(fragmentContainer.context,  "저장을 실패했습니다.", Toast.LENGTH_LONG).show()
                }
        }else{
            Toast.makeText(fragmentContainer.context,  "사진을 업로드해주세요.", Toast.LENGTH_LONG).show()
        }

        /*
        val itemimg = add_image.drawable
        val itemname  = add_item_name_tv.text.toString()
        val itemprice = Integer.parseInt(add_item_price_tv.text.toString())
        val itemexplain = add_item_explain_et.text.toString()

        val result = HashMap<Any, Any>()
        result["img"] = itemimg
        result["name"] = itemname
        result["price"] = itemprice
        result["explain"] = itemexplain

        writeNewItem(itemimg, itemname, itemprice, itemexplain)*/
    }

    private fun addUploadRecordToDb(uri : String) {
        val db = FirebaseFirestore.getInstance()

        val data = HashMap<String, Any>()
        data["imageUrl"] = uri

        db.collection("posts").add(data)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(fragmentContainer.context, "Saved to DB", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(fragmentContainer.context, "Error saving to DB", Toast.LENGTH_LONG).show()
            }
    }

/*
    private fun writeNewItem(ItemImg :  ,ItemName: String, ItemPrice: Int, ItemExplain : String){
        val item = Add_itemData(ItemImg, ItemName,ItemPrice,ItemExplain)

        database.child("Items").child(ItemName).child("ItemName").setValue(item)
            .addOnSuccessListener {

                Toast.makeText(fragmentContainer.context,  "저장을 성공하였습니다..", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                fun onFailure(){Toast.makeText(fragmentContainer.context,  "저장을 실패했습니다.", Toast.LENGTH_LONG).show()}
            }
    }
*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY){
                currentImageUri  = data?.data

                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, currentImageUri)
                    Log.d("pics", bitmap.toString())
                    add_image.setImageBitmap(bitmap)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }else{
            Log.d("ActivityResult", "something wrong")
        }
    }
}
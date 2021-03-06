package com.example.howmuch.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.howmuch.R
import kotlinx.android.synthetic.main.fragment_signin.view.*

/**
 * A simple [Fragment] subclass.
 */
class SigninFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_signin, container, false)

        root.login_button.setOnClickListener {
            findNavController().navigate(R.id.action_signinFragment2_to_itemlistFragment)
        }

        return root
    }


}

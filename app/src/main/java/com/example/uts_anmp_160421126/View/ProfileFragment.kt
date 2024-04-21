package com.example.uts_anmp_160421126.View

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uts_anmp_160421126.R
import com.example.uts_anmp_160421126.databinding.FragmentLoginBinding
import com.example.uts_anmp_160421126.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val PREF_NAME="user_session"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = requireActivity().getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        val username = sharedPref.getString("username","")
        val password = sharedPref.getString("password","")

        binding.txtUsernameProfile.setText(username)
        binding.txtPasswordProfile.setText(password)
    }


}
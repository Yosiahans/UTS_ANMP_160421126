package com.example.uts_anmp_160421126.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_anmp_160421126.R
import com.example.uts_anmp_160421126.databinding.FragmentRegisBinding

class RegisFragment : Fragment() {

    private lateinit var binding:FragmentRegisBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button3.setOnClickListener{
            val username = binding.txtUsernameRegis.text.toString()
            val email = binding.txtEmailRegis.text.toString()
            val password = binding.txtPasswordRegis.text.toString()
            if (username != "" && password != "" && email!=""){
                val url = "http://10.0.2.2/anmp/add_account.php"
                val stringRequest = object : StringRequest(
                    Request.Method.POST, url,
                    Response.Listener { response ->
                        if (response == "{\"result\":\"success\"}") {
                            Toast.makeText(context, "Account Created ", Toast.LENGTH_SHORT).show()

                            val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
                            Navigation.findNavController(it).navigate(action)
                        } else {
                            Toast.makeText(context, "Please Try Again", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener {
                        Toast.makeText(context, "Error: " + it.message, Toast.LENGTH_SHORT).show()
                    }) {

                }
                Volley.newRequestQueue(context).add(stringRequest)
            }
            else{
                Toast.makeText(context, " Username and Password Cant Be Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }




}
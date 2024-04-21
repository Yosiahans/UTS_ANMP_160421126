package com.example.uts_anmp_160421126.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_anmp_160421126.R
import com.example.uts_anmp_160421126.databinding.ActivityMainBinding
import com.example.uts_anmp_160421126.databinding.ActivityRegisBinding

class RegisActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_regis)


        binding.btnRegister.setOnClickListener(){
            val username = binding.txtUsernameRegister.text.toString()
            val email = binding.txtEmailRegister.text.toString()
            val password = binding.txtPasswordRegister.text.toString()
            if (username != "" && password != "" && email!=""){
                val url = "http://10.0.2.2/anmp/register.php"
                val stringRequest = object : StringRequest(
                    Request.Method.POST, url,
                    Response.Listener { response ->
                        if (response == "{\"result\":\"success\"}") {
                            Toast.makeText(this, "Account Created ", Toast.LENGTH_SHORT).show()

                            val action = RegisFragmentDirections.RegisToLogin()
                            Navigation.findNavController(it).navigate(action)
                        } else {
                            Toast.makeText(this, "Please Try Again" + response, Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener {
                        Toast.makeText(this, "Error: " + it.message, Toast.LENGTH_SHORT).show()
                    }) {
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params["username"] = username
                        params["password"] = password
                        params["email"] = email
                        return params
                    }
                }
                Volley.newRequestQueue(this).add(stringRequest)
            }
            else{
                Toast.makeText(this, " Username and Password Cant Be Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
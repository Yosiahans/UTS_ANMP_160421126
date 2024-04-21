package com.example.uts_anmp_160421126.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_anmp_160421126.R
import com.example.uts_anmp_160421126.databinding.ActivityLoginBinding
import com.example.uts_anmp_160421126.databinding.ActivityMainBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private val PREF_NAME = "user_session"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener(){
            val usn = binding.txtUsername.text.toString()
            val pwd = binding.txtPassword.text.toString()
            if (usn != "" && pwd != ""){
                val url = "http://10.0.2.2/anmp/login.php"
                val stringRequest = object : StringRequest(
                    Request.Method.POST, url,
                    Response.Listener { response ->
                        if (response == "{\"result\":\"success\"}") {
                            Toast.makeText(this, "Welcome ", Toast.LENGTH_SHORT).show()

                            saveUserSession(usn,pwd)

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener {
                        Toast.makeText(this , "Error: " + it.message, Toast.LENGTH_SHORT).show()
                    }) {
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params["username"] = usn
                        params["password"] = pwd
                        return params
                    }


                }
                Volley.newRequestQueue(this).add(stringRequest)
            }
            else{
                Toast.makeText(this, "Username and Password Cant Be Empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.txtRegis.setOnClickListener(){
            val intent = Intent(this, RegisActivity::class.java)
            startActivity(intent)
        }





        }

    private fun saveUserSession(username: String,pass:String) {
        val sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("username", username)
            putString("password", pass)

            apply()
        }
    }
}
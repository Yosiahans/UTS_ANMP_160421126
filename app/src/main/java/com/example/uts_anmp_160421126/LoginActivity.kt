//package com.example.uts_anmp_160421126
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Toast
//import com.android.volley.Request
//import com.android.volley.Response
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.example.uts_anmp_160421126.Model.Users
//import com.example.uts_anmp_160421126.databinding.ActivityLoginBinding
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import org.json.JSONObject
//
//class LoginActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityLoginBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding =ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btnLogin.setOnClickListener(){
//            val username = binding.txtUsername.text.toString()
//            val password = binding.txtPassword.text.toString()
//
//            val q = Volley.newRequestQueue(this@LoginActivity)
//            val url = "https://ubaya.me/native/160421126/UAS/sign_in.php"
//            val stringRequest = object : StringRequest(
//                Request.Method.POST,
//                url, Response.Listener
//                {
//                    Log.d("apiresult",it);
////                    Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
////                    val intent = Intent(this, LoginActivity::class.java)
//                    val obj = JSONObject(it)
//
//                    if (obj.getString("result") == "OK"){
////                        val action = student
//                        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
//
//                        val data = obj.getJSONArray("data")
//                        val sType = object: TypeToken<List<Users>>(){}.type
//                        user = Gson().fromJson(data.toString(), sType) as ArrayList<Users>
////                        val lm = LinearLayoutManager(root.context)
//
//                        Log.d("apiresult", user.toString())
//                    } else {
//                        Toast.makeText(this,username , Toast.LENGTH_SHORT).show()
//                    }
//                },
//                {
//                    Log.e("apiresult",it.message.toString());
//                }
//        }
//    }
//}
package com.example.uts_anmp_160421126.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_anmp_160421126.Model.News
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NewsViewModel(application: Application):AndroidViewModel(application) {
    val NewsLD = MutableLiveData<ArrayList<News>>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/anmp/getNews.php"
        val StringRequest = StringRequest(Request.Method.GET, url, {
            val sType = object : TypeToken<List<News>>() {}.type
            val result = Gson().fromJson<List<News>>(it, sType)
            NewsLD.value = result as ArrayList<News>?

            Log.d("Show Volley", it)
        },
            {
                Log.d("showvoley", it.toString())

            })
        StringRequest.tag = TAG
        queue?.add(StringRequest)

    }

}


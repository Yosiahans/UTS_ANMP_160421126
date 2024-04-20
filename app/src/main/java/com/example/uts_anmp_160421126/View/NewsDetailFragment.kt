package com.example.uts_anmp_160421126.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.example.uts_anmp_160421126.Model.News
import com.example.uts_anmp_160421126.R


class NewsDetailFragment : Fragment() {
    val newsLD = MutableLiveData<News>()
//    private lateinit var bindin

    fun fetch(){
        val news1 = News("160055","P Aja","Budi","www.google.com")
        newsLD.value = news1

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }


}
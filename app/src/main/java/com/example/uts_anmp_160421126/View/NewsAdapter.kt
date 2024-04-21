package com.example.uts_anmp_160421126.View

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_anmp_160421126.Model.News
import com.example.uts_anmp_160421126.databinding.FragmentMainBinding
import com.example.uts_anmp_160421126.databinding.NewsListItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class NewsAdapter(val newsList:ArrayList<News>)
    :RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(var binding: NewsListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.txtJudul.text = newsList[position].judul
        holder.binding.txtAuthor.text = newsList[position].author

        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(newsList[position].image).into(holder.binding.imageView, object:
            Callback {
            override fun onSuccess() {
                holder.binding.imageView.visibility = View.VISIBLE
            }
            override fun onError(e: Exception?) {
                Log.e("picasso_error", e.toString())
                }
            })
//        holder.binding.imageView.setImageResource()
        holder.binding.btnDetail.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToNewsDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateNewsList(newNewsList:ArrayList<News>){
        newsList.clear()
        newsList.addAll(newNewsList)
        notifyDataSetChanged()

    }
}
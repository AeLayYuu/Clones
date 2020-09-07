package com.example.movies.ui.topRated

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.ui.topRated.view.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_top_rated.view.*

class TopRatedAdapter (var topRatedList: List<Result> = ArrayList()):RecyclerView.Adapter<TopRatedAdapter.HomeViewHolder>() {

    var mClickListener : ClickListener? =null

    interface ClickListener{
        fun onClick(result: Result)
    }

    fun setOnClickListener(clickListener : ClickListener)
    {
        this.mClickListener= clickListener
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        lateinit var result: Result
        init {
            itemView.setOnClickListener(this)
        }
        fun bindLatest(result: Result)
        {
            this.result = result
            var imgUrl :String ="https://image.tmdb.org/t/p/w500/"

            //itemView.movieTitle.text=result.title
            //itemView.movieOverview.text= result.overview

            Picasso.get().load( imgUrl + result.poster_path).placeholder(R.drawable.movies).into(itemView.posterImage)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(result)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_top_rated,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topRatedList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindLatest(topRatedList[position])
    }
    fun updateResult(result : List<Result>)
    {
        topRatedList= result
        notifyDataSetChanged()
    }
}
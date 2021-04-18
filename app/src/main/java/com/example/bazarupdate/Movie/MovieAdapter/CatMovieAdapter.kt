package com.example.bazarupdate.Movie.MovieAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.Movie.CatMovie
import com.example.bazarupdate.R
import com.squareup.picasso.Picasso

class CatMovieAdapter(var list:List<CatMovie>, var onItemClick:(item: CatMovie)->Unit):RecyclerView.Adapter<CatMovieAdapter.CatMovieViewHolder>() {

    class CatMovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var imgIcon = itemView.findViewById<ImageView>(R.id.img_catGameRow_icon)
        var txtName = itemView.findViewById<TextView>(R.id.txt_catGameRow_name)
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_catGameRow_parent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatMovieViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cat_game_row, parent, false)
        return CatMovieViewHolder(view)
    }

    override fun onBindViewHolder(holderMovie: CatMovieViewHolder, position: Int) {

        holderMovie.txtName.text = list[position].cat_name
        Picasso.get().load(list[position].cat_icon).into(holderMovie.imgIcon)
        holderMovie.parent.setOnClickListener {

            onItemClick(list[position])

        }    }

    override fun getItemCount(): Int {
        return list.size
    }
}
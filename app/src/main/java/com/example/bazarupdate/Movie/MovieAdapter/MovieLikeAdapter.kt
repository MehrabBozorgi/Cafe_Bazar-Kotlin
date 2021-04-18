package com.example.bazarupdate.Movie.MovieAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.Movie.Movie
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class MovieLikeAdapter(var list: List<Movie>, var onClickItem: (item: Movie) -> Unit) :
    RecyclerView.Adapter<MovieLikeAdapter.MovieLikeViewHolder>() {

    class MovieLikeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_filmIranRow_icon)
        var txtName = itemView.findViewById<TextView>(R.id.txt_filmIranRow_name)
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_filmIranRow_parent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieLikeViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.film_iran_row, parent, false)
        return MovieLikeViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieLikeViewHolder, position: Int) {

        holder.txtName.text = list[position].name
        Picasso.get().load(list[position].icon).into(holder.imgIcon)
        holder.parent.setOnClickListener {
            onClickItem(list[position])

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
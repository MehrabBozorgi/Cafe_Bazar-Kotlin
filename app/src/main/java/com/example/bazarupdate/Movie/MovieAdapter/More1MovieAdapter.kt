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

class More1MovieAdapter(var list: List<Movie>, var onClickMoreGame: (item: Movie) -> Unit) :
    RecyclerView.Adapter<More1MovieAdapter.More1MovieViewHolder>() {

    class More1MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_moreMovieForYouRow_icon)
        var txtName = itemView.findViewById<TextView>(R.id.txt_moreMovieForYouRow_name)
//        var txtKargardan = itemView.findViewById<TextView>(R.id.txt_moreMovieForYouRow_kargardan)
        var txtYear = itemView.findViewById<TextView>(R.id.txt_moreMovieForYouRow_year)
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_moreMovieForYouRow_parent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): More1MovieViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.more_movie_for_you, parent, false)
        return More1MovieViewHolder(view)

    }

    override fun onBindViewHolder(holder: More1MovieViewHolder, position: Int) {

        holder.txtName.text = list[position].name
//        holder.txtKargardan.text = list[position].k
        holder.txtYear.text = list[position].sale_sakh
        Picasso.get().load(list[position].icon).into(holder.imgIcon)

        holder.parent.setOnClickListener {

            onClickMoreGame(list[position])

        }
    }

    override fun getItemCount(): Int {

        return list.size
    }}


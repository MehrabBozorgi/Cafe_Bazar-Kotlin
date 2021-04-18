package com.example.bazarupdate.Game.GameAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class SlideGameAdapter(var list: List<String>) :
    RecyclerView.Adapter<SlideGameAdapter.SlideViewHolder>() {

    class SlideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img = itemView.findViewById<RoundedImageView>(R.id.img_slideRow_slide)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.slide_row, parent, false)
        return SlideViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {

        var list2: String = list[position]
        Picasso.get().load(list2).into(holder.img)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
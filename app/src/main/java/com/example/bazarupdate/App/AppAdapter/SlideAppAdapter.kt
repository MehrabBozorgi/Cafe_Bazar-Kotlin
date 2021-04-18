package com.example.bazarupdate.App.AppAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class SlideAppAdapter(var list: List<String>) :
    RecyclerView.Adapter<SlideAppAdapter.SlideAppViewHolder>() {

    class SlideAppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img = itemView.findViewById<RoundedImageView>(R.id.img_slideAppRow_slide)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideAppViewHolder {

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.slide_app_row, parent, false)
        return SlideAppViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlideAppViewHolder, position: Int) {

        var list2: String = list[position]
        Picasso.get().load(list2).into(holder.img)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
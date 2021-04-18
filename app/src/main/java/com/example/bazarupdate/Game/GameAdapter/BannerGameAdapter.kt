package com.example.bazarupdate.Game.GameAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.Banners
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class BannerGameAdapter(var list: List<Banners>) :
    RecyclerView.Adapter<BannerGameAdapter.BannerViewHolder>() {

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_bannerRow_icon)!!
        var imgImage = itemView.findViewById<RoundedImageView>(R.id.img_bannerRow_image)!!
        var txtName = itemView.findViewById<TextView>(R.id.txt_bannerRow_name)!!
        var txtSize = itemView.findViewById<TextView>(R.id.txt_bannerRow_size)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.banners_row, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {

        holder.txtName.text = list[position].name
        holder.txtSize.text = list[position].size+" مگ"
        Picasso.get().load(list[position].icon).into(holder.imgIcon)
        Picasso.get().load(list[position].image).into(holder.imgImage)
    }

    override fun getItemCount(): Int {

        return list.size
    }
}
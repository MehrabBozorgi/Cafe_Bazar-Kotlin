package com.example.bazarupdate.App.AppAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.MoreGame
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class ExtraAppAdapter(var list: List<MoreGame>, var onClickExtraGame: (id: MoreGame) -> Unit) :
    RecyclerView.Adapter<ExtraAppAdapter.ExtraAppViewHolder>() {

    class ExtraAppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_moreGameRow_icon)!!
        var txtName = itemView.findViewById<TextView>(R.id.txt_moreGameRow_name)!!
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_moreGameRow_parent)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraAppViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.more_game_row, parent, false)
        return ExtraAppViewHolder(view)

    }

    override fun onBindViewHolder(holder: ExtraAppViewHolder, position: Int) {

        holder.txtName.text = list[position].name
        Picasso.get().load(list[position].icon).into(holder.imgIcon)

        holder.parent.setOnClickListener {

            onClickExtraGame(list[position])

        }
    }

    override fun getItemCount(): Int {

        return list.size
    }
}
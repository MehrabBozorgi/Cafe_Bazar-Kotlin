package com.example.bazarupdate.Game.GameAdapter

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

class MoreGameAdapter(var list: List<MoreGame>, var onClickMoreGame: (item: MoreGame) -> Unit) :
    RecyclerView.Adapter<MoreGameAdapter.MoreGameViewHolder>() {

    class MoreGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_moreGameRow_icon)
        var txtName = itemView.findViewById<TextView>(R.id.txt_moreGameRow_name)
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_moreGameRow_parent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreGameViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.more_game_row, parent, false)
        return MoreGameViewHolder(view)

    }

    override fun onBindViewHolder(holder: MoreGameViewHolder, position: Int) {

        holder.txtName.text = list[position].name
        Picasso.get().load(list[position].icon).into(holder.imgIcon)

        holder.parent.setOnClickListener {

            onClickMoreGame(list[position])

        }
    }

    override fun getItemCount(): Int {

        return list.size
    }}

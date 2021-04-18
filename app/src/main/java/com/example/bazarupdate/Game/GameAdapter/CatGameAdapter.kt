package com.example.bazarupdate.Game.GameAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.CatGame
import com.example.bazarupdate.R
import com.squareup.picasso.Picasso

class CatGameAdapter(var cat: List<CatGame>, var OnClickCatGame: (item: CatGame) -> Unit) :
    RecyclerView.Adapter<CatGameAdapter.CatGameViewHolder>() {
    class CatGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgIcon = itemView.findViewById<ImageView>(R.id.img_catGameRow_icon)
        var txtName = itemView.findViewById<TextView>(R.id.txt_catGameRow_name)
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_catGameRow_parent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatGameViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.cat_game_row, parent, false)
        return CatGameViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatGameViewHolder, position: Int) {

        holder.txtName.text = cat[position].cat_name
        Picasso.get().load(cat[position].cat_icon).into(holder.imgIcon)
        holder.parent.setOnClickListener {

            OnClickCatGame(cat[position])

        }
    }

    override fun getItemCount(): Int {
        return cat.size
    }
}
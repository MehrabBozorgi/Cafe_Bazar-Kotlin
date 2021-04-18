package com.example.bazarupdate.Game.GameAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.MoreGame
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class MoreGameForYouAdapter(var list: List<MoreGame>, var onClickMore:(item: MoreGame)->Unit) :
    RecyclerView.Adapter<MoreGameForYouAdapter.moreGameForYouViewHolder>() {

    class moreGameForYouViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_moreGameForYouRow_icon)!!
        var txtName = itemView.findViewById<TextView>(R.id.txt_moreGameForYouRow_name)!!
        var txtKind = itemView.findViewById<TextView>(R.id.txt_moreGameForYouRow_kind)!!
        var txtDownload = itemView.findViewById<TextView>(R.id.txt_moreGameForYouRow_download)!!
        var btnInstall = itemView.findViewById<Button>(R.id.btn_moreGameForYouRow_install)!!
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_moreGameForYouRow_parent)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): moreGameForYouViewHolder {

        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.more_game_for_you_row, parent, false)
        return moreGameForYouViewHolder(view)

    }

    override fun onBindViewHolder(holder: moreGameForYouViewHolder, position: Int) {

        holder.txtName.text = list[position].name
        holder.txtKind.text = list[position].kind
        holder.txtDownload.text = list[position].download + " هزار"
        Picasso.get().load(list[position].icon).into(holder.imgIcon)
//        holder.btnInstall.text=list[position].name
        holder.parent.setOnClickListener {

            onClickMore(list[position])

        }
        if (holder.txtKind.text.equals("رایگان"))
        {
            holder.txtKind.visibility= GONE
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
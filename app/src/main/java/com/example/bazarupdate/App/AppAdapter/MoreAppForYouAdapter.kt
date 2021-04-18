package com.example.bazarupdate.App.AppAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.MoreGame
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class MoreAppForYouAdapter(var list: List<MoreGame>, var onClickMore: (item: MoreGame) -> Unit) :
    RecyclerView.Adapter<MoreAppForYouAdapter.MoreAppForYouViewHolder>() {

    class MoreAppForYouViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_moreAppForYouRow_icon)!!
        var txtName = itemView.findViewById<TextView>(R.id.txt_moreAppForYouRow_name)!!
        var txtKind = itemView.findViewById<TextView>(R.id.txt_moreAppForYouRow_kind)!!
        var txtDownload = itemView.findViewById<TextView>(R.id.txt_moreAppForYouRow_download)!!
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_moreAppForYouRow_parent)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreAppForYouViewHolder {

        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.more_app_for_you_row, parent, false)
        return MoreAppForYouViewHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MoreAppForYouViewHolder, position: Int) {

        holder.txtName.text = list[position].name
        holder.txtKind.text = list[position].kind
        holder.txtDownload.text = list[position].downloads + " هزار"
        Picasso.get().load(list[position].icon).into(holder.imgIcon)
        holder.parent.setOnClickListener {

            onClickMore(list[position])

        }
        if (holder.txtKind.text.equals("رایگان")) {
            holder.txtKind.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}
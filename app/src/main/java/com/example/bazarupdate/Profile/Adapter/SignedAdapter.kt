package com.example.bazarupdate.Profile.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.R
import com.example.bazarupdate.Room.RCourse
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class SignedAdapter(var list: List<RCourse>, var onClick: (course:RCourse) -> Unit) :
    RecyclerView.Adapter<SignedAdapter.SignedViewHolder>() {

    class SignedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.img_signedAdapterRow_icon)!!
        var txtName = itemView.findViewById<TextView>(R.id.txt_signedAdapterRow_name)!!
        var txtSize = itemView.findViewById<TextView>(R.id.txt_signedAdapterRow_size)!!
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_signedAdapterRow_parent)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignedViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.save_app, parent, false)
        return SignedViewHolder(view)
    }

    override fun onBindViewHolder(holder: SignedViewHolder, position: Int) {
        holder.txtName.text = list[position].name
        holder.txtSize.text = list[position].size+" مگابایت"
        Picasso.get().load(list[position].icon).into(holder.imgIcon)
        holder.parent.setOnClickListener {

            onClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
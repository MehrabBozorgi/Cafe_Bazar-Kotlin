package com.example.bazarupdate.Search

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

class SearchAdapter(var list: List<MoreGame>,var onClick:(id:MoreGame)->Unit) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName = itemView.findViewById<TextView>(R.id.txt_searchRow_name)!!
        var imgIcon = itemView.findViewById<RoundedImageView>(R.id.imgSearch_icon)!!
        var parent = itemView.findViewById<RelativeLayout>(R.id.searchParent)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.search_row, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        Picasso.get().load(list[position].icon).into(holder.imgIcon)
        holder.txtName.text = list[position].name
        holder.parent.setOnClickListener {

            onClick(list[position])

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
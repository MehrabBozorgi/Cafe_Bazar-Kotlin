package com.example.bazarupdate.Movie.MovieAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.Movie.Fasl
import com.example.bazarupdate.R

class FaslAdapter(var list: List<Fasl>, var onClick: (item: Fasl) -> Unit) :
    RecyclerView.Adapter<FaslAdapter.FaslViewHolder>() {
    class FaslViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName = itemView.findViewById<TextView>(R.id.txt_faslRow_name)
        var btnPlay = itemView.findViewById<Button>(R.id.btn_faslRow_play)
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_faslRow_parent)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaslViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.fasl_row, parent, false)
        return FaslViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaslViewHolder, position: Int) {
        holder.txtName.text = list[position].chand_fasl+"  فصل"
        holder.parent.setOnClickListener {

            onClick(list[position])

        }
    }

    override fun getItemCount(): Int {
return list.size    }
}
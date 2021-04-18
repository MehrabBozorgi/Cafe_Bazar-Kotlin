package com.example.bazarupdate.App.AppAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.GetComment
import com.example.bazarupdate.R

class CommentAppAdapter(var comment: List<GetComment>) :
    RecyclerView.Adapter<CommentAppAdapter.CommentAppViewHolder>() {

    class CommentAppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtName = itemView.findViewById<TextView>(R.id.txt_commentRow_name)!!
        var txtComment = itemView.findViewById<TextView>(R.id.txt_fragmentRow_comment)!!
        var txtDate = itemView.findViewById<TextView>(R.id.txt_commentRow_date)!!


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAppViewHolder {

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.comment_game_row, parent, false)
        return CommentAppViewHolder(view)

    }

    override fun onBindViewHolder(holder: CommentAppViewHolder, position: Int) {

        holder.txtName.text = comment[position].comment_name
        holder.txtDate.text = comment[position].date
        holder.txtComment.text = comment[position].comment!!

    }

    override fun getItemCount(): Int {
        return comment.size
    }
}
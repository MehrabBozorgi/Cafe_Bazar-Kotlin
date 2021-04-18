package com.example.bazarupdate.Movie.MovieAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.CommentMovie
import com.example.bazarupdate.R

class CommentMovieAdapter (var comment: List<CommentMovie>) :
    RecyclerView.Adapter<CommentMovieAdapter.CommentMovieViewHolder>() {

    class CommentMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName = itemView.findViewById<TextView>(R.id.txt_commentRow_name)
        var txtComment = itemView.findViewById<TextView>(R.id.txt_fragmentRow_comment)
        var txtDate = itemView.findViewById<TextView>(R.id.txt_commentRow_date)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentMovieViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.comment_game_row, parent, false)
        return CommentMovieViewHolder(view)

    }

    override fun onBindViewHolder(holder: CommentMovieViewHolder, position: Int) {

        holder.txtName.text=comment[position].comment_name
        holder.txtDate.text=comment[position].date
        holder.txtComment.text=comment[position].comment

    }

    override fun getItemCount(): Int {
        return comment.size
    }

}
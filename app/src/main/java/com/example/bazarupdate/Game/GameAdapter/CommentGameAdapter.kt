package com.example.bazarupdate.Game.GameAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Model.App_Game.GetComment
import com.example.bazarupdate.R

class CommentGameAdapter(var comment: List<GetComment>) :
    RecyclerView.Adapter<CommentGameAdapter.CommentGameViewHolder>() {

    class CommentGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtName = itemView.findViewById<TextView>(R.id.txt_commentRow_name)
        var txtComment = itemView.findViewById<TextView>(R.id.txt_fragmentRow_comment)
        var txtDate = itemView.findViewById<TextView>(R.id.txt_commentRow_date)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentGameViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.comment_game_row, parent, false)
        return CommentGameViewHolder(view)

    }

    override fun onBindViewHolder(holderGame: CommentGameViewHolder, position: Int) {

    holderGame.txtName.text=comment[position].comment_name
    holderGame.txtDate.text=comment[position].date
    holderGame.txtComment.text=comment[position].comment!!

    }

    override fun getItemCount(): Int {
        return comment.size
    }
}
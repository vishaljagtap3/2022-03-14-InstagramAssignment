package com.aavidsoft.instagramassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aavidsoft.instagramassignment.R
import com.aavidsoft.instagramassignment.models.Post

class PostsAdapter(var posts : ArrayList<Post>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    class PostViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var txtAuthor : TextView = itemView.findViewById(R.id.txtAuthor)
        var txtPostedOn : TextView = itemView.findViewById(R.id.txtPostedOn)
        var txtTitle : TextView = itemView.findViewById(R.id.txtTitle)
        var imgPost : ImageView = itemView.findViewById(R.id.imgPost)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_view, null)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        var post = posts[position]
        holder.let {
            it.txtTitle.text = post.author
            it.txtPostedOn.text = post.postedOn
            it.txtTitle.text = post.title
            it.imgPost.setImageResource(post.imageId)
        }

        /*var post = posts[position]

        holder.txtAuthor.text = post.author
        holder.txtPostedOn.text = post.postedOn
        holder.txtTitle.text = post.title
        holder.imgPost.setImageResource(post.imageId)*/

    }
}
package com.aavidsoft.instagramassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aavidsoft.instagramassignment.R
import com.aavidsoft.instagramassignment.models.Post
import com.aavidsoft.instagramassignment.views.PostView

class PostsAdapter(var posts: ArrayList<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var postView = itemView as PostView

        init {
            postView.txtAuthor.setOnClickListener {
                onPostClickListener?.onAuthorClick(postView,adapterPosition)
            }
            postView.txtTitle.setOnClickListener {
                onPostClickListener?.onTitleClick(postView,adapterPosition)
            }
            postView.txtLike.setOnClickListener {
                onPostClickListener?.onLikeClick(postView,adapterPosition)
            }
            postView.imgPost.setOnClickListener {
                onPostClickListener?.onImageClick(postView,adapterPosition)
            }
            postView.iconShare.setOnClickListener {
                onPostClickListener?.onShareClick(postView,adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostView(parent.context))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.postView.post = posts[position]
    }

    interface OnPostClickListener {
        fun onAuthorClick(postView : PostView, position : Int)
        fun onTitleClick(postView : PostView, position : Int)
        fun onImageClick(postView : PostView, position : Int)
        fun onLikeClick(postView : PostView, position : Int)
        fun onShareClick(postView : PostView, position : Int)
    }

    var onPostClickListener : OnPostClickListener? = null
}
package com.aavidsoft.instagramassignment.ui

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aavidsoft.instagramassignment.R
import com.aavidsoft.instagramassignment.adapters.PostsAdapter
import com.aavidsoft.instagramassignment.models.Post
import com.aavidsoft.instagramassignment.threads.PostsThread
import com.aavidsoft.instagramassignment.views.PostView

class PostsListActivity : AppCompatActivity() {

    private lateinit var recyclerPosts : RecyclerView
    private lateinit var posts : ArrayList<Post>
    private lateinit var postsAdapter: PostsAdapter
    private lateinit var progressBar : ProgressBar

    private var pageNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        setUpListeners()

    }

    inner class PostsHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            progressBar.visibility = View.GONE

            posts.addAll(msg.obj as ArrayList<Post>)
            postsAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpListeners() {
        recyclerPosts.addOnScrollListener(RecyclerPostsScrollListener())
        postsAdapter.onPostClickListener = PostViewClickListener()
    }


    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private inner class PostViewClickListener : PostsAdapter.OnPostClickListener {
        override fun onAuthorClick(postView: PostView, position: Int) {
            mt("Author: Details of ${posts[position].author}")
        }

        override fun onTitleClick(postView: PostView, position: Int) {
            mt("Title: ${posts[position].title}")
        }

        override fun onImageClick(postView: PostView, position: Int) {
            mt("Image: ${posts[position].title}")
        }

        override fun onLikeClick(postView: PostView, position: Int) {
            posts[position].numberOfLikes++
            postsAdapter.notifyDataSetChanged()
        }

        override fun onShareClick(postView: PostView, position: Int) {
            mt("Share: ${posts[position].title}")
        }

    }

    private inner class RecyclerPostsScrollListener : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            if (!recyclerView.canScrollVertically(1)) {
                progressBar.visibility = View.VISIBLE
                PostsThread(PostsHandler())
                    .execute(Integer(pageNumber++))
            }
        }
    }

    private fun init() {
        setContentView(R.layout.posts_list_activity)

        progressBar = findViewById(R.id.progressBar)
        recyclerPosts = findViewById(R.id.recyclerPosts)

        recyclerPosts.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        posts =  ArrayList<Post>()
        addDummyPosts()

        //set up adapter
        postsAdapter = PostsAdapter(posts)
        recyclerPosts.adapter = postsAdapter
    }

    private fun addDummyPosts() {
        posts.add(
            Post(101, "12 April 2022", R.drawable.dog, "Android as the future of Mobile computing in next 5 years", "Vishal Jagtap")
        )
        posts.add(
            Post(101, "13 April 2022", R.mipmap.ic_launcher, "IOT and open source platforms which help build future applications", "Vishal Jagtap")
        )
    }
}
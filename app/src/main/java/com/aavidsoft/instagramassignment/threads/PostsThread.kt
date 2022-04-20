package com.aavidsoft.instagramassignment.threads

import android.os.AsyncTask
import android.os.Handler
import android.os.Message
import com.aavidsoft.instagramassignment.R
import com.aavidsoft.instagramassignment.models.Post

class PostsThread(val postsHandler : Handler) : AsyncTask<Integer, Any?, ArrayList<Post>>() {

    override fun doInBackground(vararg pageNumber: Integer?): ArrayList<Post>? {
        Thread.sleep(5000)

        var posts = ArrayList<Post>()

        for(postIndex in 1..5) {
            posts.add(
                Post(
                    postIndex,
                    "12 April 2022",
                    R.drawable.dog,
                    "This is a demo title, to test the applications.. ${postIndex}",
                    "Vishal Jagtap"
                )
            )
        }

        return posts
    }

    override fun onPostExecute(result: ArrayList<Post>?) {
        super.onPostExecute(result)
        var message = Message()
        message.obj = result
        postsHandler.sendMessage(message)
    }

}
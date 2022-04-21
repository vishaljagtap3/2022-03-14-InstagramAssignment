package com.aavidsoft.instagramassignment.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.aavidsoft.instagramassignment.R
import com.aavidsoft.instagramassignment.models.Post


class PostView(context: Context, attributeSet: AttributeSet? = null) :
    LinearLayout(context, attributeSet) {

    lateinit var txtAuthor : TextView
    lateinit var txtTitle : TextView
    lateinit var imgPost : ImageView
    lateinit var txtPostedOn : TextView
    lateinit var txtLike : TextView
    lateinit var iconShare : ImageView

    var post : Post? = null
    set(value) {
        field = value
        field!!.let {
            txtAuthor.text = it.author
            txtTitle.text = it.title
            txtPostedOn.text = it.postedOn
            txtLike.text = "${it.numberOfLikes} Likes"
            imgPost.setImageResource(it.imageId)
        }
    }


    init {
        var view = LayoutInflater.from(context)
            .inflate(R.layout.post_view, this)
        //this.addView(view)

        txtLike = view.findViewById(R.id.txtNumberOfLikes)
        txtPostedOn = view.findViewById(R.id.txtPostedOn)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtAuthor = view.findViewById(R.id.txtAuthor)
        imgPost = view.findViewById(R.id.imgPost)
        iconShare = view.findViewById(R.id.iconShare)



    }

}
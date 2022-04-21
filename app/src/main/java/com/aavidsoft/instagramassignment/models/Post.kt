package com.aavidsoft.instagramassignment.models

data class Post(
    var id : Int,
    var postedOn : String,
    var imageId : Int,
    var title : String,
    var author : String,
    var numberOfLikes : Int = 0
)
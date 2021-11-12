package com.example.consumeapi_jetpackcompose.data.remote.responses


import com.google.gson.annotations.SerializedName

data class StatX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
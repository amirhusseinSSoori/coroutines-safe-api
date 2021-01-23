package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("about_me")
    val about_me: String?=null,
    @SerializedName("first_name")
    val firstName: String?=null,
    @SerializedName("last_name")
    val lastName: String?=null,
    @SerializedName("phone")
    val phone: String?=null,
    @SerializedName("user_id")
    val userID: Int?=null,
    @SerializedName("username")
    val userName: String?=null
)
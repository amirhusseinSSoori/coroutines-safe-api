package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class UserAvatar(
    @SerializedName("avatar_id")
    val avatarId: Int?=null,
    @SerializedName("update_time")
    val updateTime: Long?=null,
    @SerializedName("url")
    val url: String?=null,
    @SerializedName("user_id")
    val userId: Int?=null)
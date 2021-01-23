package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Chat(
    @SerializedName("chat_id")
    val chatID: Int?=null,
    @SerializedName("message")
    val message: String?=null,
    @SerializedName("status")
    val status: Int?=null,
    @SerializedName("tran_id")
    val tranId: Int?=null,
    @SerializedName("update_time")
    val updateTime: Long?=null,
    @SerializedName("user_id")
    val userId: Int?=null)
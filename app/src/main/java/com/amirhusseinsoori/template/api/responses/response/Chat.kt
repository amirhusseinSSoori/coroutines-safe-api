package com.amirhusseinsoori.template.api.responses.response

import com.google.gson.annotations.SerializedName

data class Chat(
    @SerializedName("chat_id")
    val chat_id: Int?=null,
    @SerializedName("message")
    val message: String?=null,
    @SerializedName("status")
    val status: Int?=null,
    @SerializedName("tran_id")
    val tran_id: Int?=null,
    @SerializedName("update_time")
    val update_time: Long?=null,
    @SerializedName("user_id")
    val user_id: Int?=null
)
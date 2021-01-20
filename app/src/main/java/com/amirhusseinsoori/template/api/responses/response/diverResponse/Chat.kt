package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "Chat")
data class Chat(

    val chat_id: Int?=null,
    val message: String?=null,
    val status: Int?=null,
    val tran_id: Int?=null,
    val update_time: Long?=null,
    val user_id: Int?=null,
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
)
package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserAvatar")
data class UserAvatar(
    val avatar_id: Int?=null,
    val update_time: Long?=null,
    val url: String?=null,
    val user_id: Int?=null,
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null
)
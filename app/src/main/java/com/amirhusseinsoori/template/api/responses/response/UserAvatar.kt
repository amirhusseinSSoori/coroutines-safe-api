package com.amirhusseinsoori.template.api.responses.response

data class UserAvatar(
    val avatar_id: Int,
    val update_time: Long,
    val url: String,
    val user_id: Int
)
package com.amirhusseinsoori.template.api.responses.response

data class User(
    val about_me: String?=null,
    val first_name: String?=null,
    val last_name: String?=null,
    val phone: String?=null,
    val user_id: Int?=null,
    val username: String?=null
)
package com.amirhusseinsoori.template.api.responses.response

data class Contact(
    val contact_id: Int,
    val first_name: String,
    val is_registered: Int,
    val last_name: String,
    val phone: String,
    val user_id: Int
)
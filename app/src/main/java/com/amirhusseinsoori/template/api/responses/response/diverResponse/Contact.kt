package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(
    val contact_id: Int?=null,
    val first_name: String?=null,
    val is_registered: Int?=null,
    val last_name: String?=null,
    val phone: String?=null,
    val user_id: Int?=null,
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null
)
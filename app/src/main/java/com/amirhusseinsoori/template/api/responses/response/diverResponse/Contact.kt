package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Contact(
    @SerializedName("contact_id")
    val contactId: Int?=null,
    @SerializedName("first_name")
    val firstName: String?=null,
    @SerializedName("is_registered")
    val isRegistered: Int?=null,
    @SerializedName("last_name")
    val lastName: String?=null,
    @SerializedName("phone")
    val phone: String?=null,
    @SerializedName("user_id")
    val userId: Int?=null
)
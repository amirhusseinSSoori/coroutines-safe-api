package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.db.Converter
import com.google.gson.annotations.SerializedName


data class Transaction(
    @SerializedName("chat")
    val chat: Chat? = null,
    @SerializedName("contact")
    val contact: Contact? = null,
    @SerializedName("properties")
    val properties: List<Property>? = null,
    @SerializedName("transaction")
    val transaction: TransactionX? = null,
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("user_avatars")
    val userAvatars: List<UserAvatar>? = null
)
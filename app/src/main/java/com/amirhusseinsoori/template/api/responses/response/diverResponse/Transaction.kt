package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.db.Converter


data class Transaction(

    val chat: Chat? = null,

    val contact: Contact? = null,

    val properties: List<Property>? = null,

    val transaction: TransactionX? = null,
    val user: User? = null,

    val user_avatars: List<UserAvatar>? = null
)
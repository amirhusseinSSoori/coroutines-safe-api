package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.db.Converter


data class Transaction(
    @Embedded
    val chat: Chat?=null,
    @Embedded
    val contact: Contact?=null,
    @TypeConverters(Converter::class)
    val properties: List<Property>?=null,
    @Embedded
    val transaction: TransactionX?=null,
    val user: User?=null,
    @TypeConverters(Converter::class)
    val user_avatars: List<UserAvatar>?=null)
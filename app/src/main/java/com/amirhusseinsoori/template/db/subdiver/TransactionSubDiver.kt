package com.amirhusseinsoori.template.db.subdiver

import androidx.room.Embedded
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.api.responses.response.diverResponse.*
import com.amirhusseinsoori.template.db.Converter

data class TransactionSubDiver(
    @Embedded
    val chat: ChatSubDiver? = null,
    @Embedded
    val contact: ContactSubDiver? = null,
    @TypeConverters(Converter::class)
    val properties: List<PropertySubDiver> ?= null,
    @Embedded
    val transaction: TransactionXSubDiver? = null,
    @Embedded
    val user: UserSubDiver? = null,
    @TypeConverters(Converter::class)
    val user_avatars: List<UserAvatarSubDiver>? = null
)





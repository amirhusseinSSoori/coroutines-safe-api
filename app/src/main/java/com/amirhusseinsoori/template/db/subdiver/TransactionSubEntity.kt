package com.amirhusseinsoori.template.db.subdiver

import androidx.room.Embedded
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.db.Converter

data class TransactionSubEntity(
    @Embedded
    val chat: ChatSubEntity? = null,
    @Embedded
    val contact: ContactSubEntity? = null,
    @TypeConverters(Converter::class)
    val properties: List<PropertySubEntity> ?= null,
    @Embedded
    val transaction: TransactionXSubEntity? = null,
    @Embedded
    val user: UserSubEntity? = null,
    @TypeConverters(Converter::class)
    val userAvatars: List<UserAvatarSubEntity>? = null
)





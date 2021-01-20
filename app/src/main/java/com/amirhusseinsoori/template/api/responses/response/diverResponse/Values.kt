package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Values(
    val passive_fullname: String?=null,
    val passive_phone: String?=null,
    val user_fullname: String?=null,
    val user_phone: String?=null, )
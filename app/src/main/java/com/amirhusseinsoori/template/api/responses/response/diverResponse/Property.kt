package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Property(
    val code: Int?=null,
    val property_id: Int?=null,
    val tran_id: Int?=null,
    val values: Values?=null
)
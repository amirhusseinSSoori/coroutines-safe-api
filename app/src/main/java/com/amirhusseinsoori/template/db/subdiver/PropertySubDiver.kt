package com.amirhusseinsoori.template.db.subdiver

import androidx.room.Embedded
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Values
import com.amirhusseinsoori.template.db.Converter

data class PropertySubDiver(
    val code: Int?=null,
    val property_id: Int?=null,
    val tran_id: Int?=null,
    @Embedded
    val values: ValuesSubDiver?=null)
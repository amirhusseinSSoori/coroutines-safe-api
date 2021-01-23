package com.amirhusseinsoori.template.db.subdiver

import androidx.room.Embedded

data class PropertySubEntity(
    val code: Int?=null,
    val propertyId: Int?=null,
    val tranId: Int?=null,
    @Embedded
    val value: ValuesSubEntity?=null)
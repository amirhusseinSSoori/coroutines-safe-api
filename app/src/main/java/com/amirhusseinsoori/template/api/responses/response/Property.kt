package com.amirhusseinsoori.template.api.responses.response

data class Property(
    val code: Int,
    val property_id: Int,
    val tran_id: Int,
    val values: Values
)
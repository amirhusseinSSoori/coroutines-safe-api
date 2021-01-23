package com.amirhusseinsoori.template.db.subdiver

data class TransactionXSubEntity (
    val amount: Double?=null,
    val creationTime: Long?=null,
    val description: String?=null,
    val status: Int?=null,
    val tranId: Int?=null,
    val updateTime: Long?=null,
    val userId: Int?=null,
    val viewType: Int?=null
    )
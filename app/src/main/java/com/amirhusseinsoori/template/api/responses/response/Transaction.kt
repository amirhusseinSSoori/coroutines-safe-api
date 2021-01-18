package com.amirhusseinsoori.template.api.responses.response

data class Transaction(
    val chat: Chat?=null,
    val contact: Contact?=null,
    val properties: List<Property>?=null,
    val transaction: TransactionX?=null,
    val user: User?=null,
    val user_avatars: List<UserAvatar>?=null
)
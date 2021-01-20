package com.amirhusseinsoori.template.repositories


import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.SampleResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Chat
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.sources.LocalDataSource
import com.amirhusseinsoori.template.sources.RemoteDataSource
import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) {


    fun favoriteLatestNews(): Flow<ApiWrapper<SampleResponse>> = remote.flowRemote()

    suspend fun getDiverRemote(token: String): ApiWrapper<DiverResponse> = remote.diverRemote(token)

    fun getRemoteLocalChat() = local.getData()
    suspend fun insetRemoteLocalChat(chat: Chat) = local.insertDataChat(chat)
}
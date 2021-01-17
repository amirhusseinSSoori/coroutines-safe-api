package com.amirhusseinsoori.template.repositories



import com.amirhusseinsoori.template.api.responses.response.SampleResponse
import com.amirhusseinsoori.template.sources.RemoteDataSource
import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val remote: RemoteDataSource
) {

    suspend fun getRemote(): ApiWrapper<SampleResponse> =remote.remoteApi()

    fun favoriteLatestNews():Flow<ApiWrapper<SampleResponse>> =remote.flowRemote()





}
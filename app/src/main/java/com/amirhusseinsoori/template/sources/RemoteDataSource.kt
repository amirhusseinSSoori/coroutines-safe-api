package com.amirhusseinsoori.template.sources

import com.amirhusseinsoori.template.api.MyApi


import com.amirhusseinsoori.template.api.responses.safe.SafeApi
import com.amirhusseinsoori.template.api.responses.response.SampleResponse

import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
        private val myApi: MyApi
) : SafeApi() {



   suspend fun remoteApi(): ApiWrapper<SampleResponse> = safeApi { myApi.showDetails() }




}

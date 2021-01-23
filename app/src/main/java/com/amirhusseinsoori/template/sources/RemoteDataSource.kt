package com.amirhusseinsoori.template.sources

import com.amirhusseinsoori.template.api.MyApi
import com.amirhusseinsoori.template.api.responses.response.DiverResponse


import com.amirhusseinsoori.template.api.responses.safe.SafeApi

import com.example.template.api.safe.ApiWrapper
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
        private val myApi: MyApi
) : SafeApi() {



    suspend fun diverRemote():ApiWrapper<DiverResponse> =safeApi { myApi.getDetailsDiver() }



}

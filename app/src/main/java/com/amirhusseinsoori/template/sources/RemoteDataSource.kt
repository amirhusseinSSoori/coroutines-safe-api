package com.amirhusseinsoori.template.sources

import com.amirhusseinsoori.template.api.MyApi
import com.amirhusseinsoori.template.api.responses.response.DiverResponse


import com.amirhusseinsoori.template.api.responses.safe.SafeApi
import com.amirhusseinsoori.template.api.responses.response.SampleResponse
import com.amirhusseinsoori.template.util.Constance

import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
        private val myApi: MyApi
) : SafeApi() {


      fun flowRemote():Flow<ApiWrapper<SampleResponse>> = flow {
          emit(safeApi { myApi.showDetailsFlow() }) // Emits the result of the request to the flow
      }

    suspend fun diverRemote(token:String):ApiWrapper<DiverResponse> =safeApi { myApi.getDetailsDiver(token) }



}

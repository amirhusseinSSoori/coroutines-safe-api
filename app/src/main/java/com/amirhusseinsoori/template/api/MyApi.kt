package com.amirhusseinsoori.template.api


import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.SampleResponse
import com.amirhusseinsoori.template.util.Constance

import retrofit2.Response
import retrofit2.http.*

interface MyApi {



    @GET("todos/1")
    fun showDetailsFlow(): Response<SampleResponse>

    @Headers("Content-Type: application/json")
    @GET("transactions")
    suspend fun getDetailsDiver(@Header("Authorization") Authorization: String): Response<DiverResponse>


}
package com.amirhusseinsoori.template.api




import com.amirhusseinsoori.template.api.responses.response.SampleResponse

import retrofit2.Response
import retrofit2.http.*

interface MyApi {


    @GET("todos/1")
    suspend fun showDetails(): Response<SampleResponse>





}
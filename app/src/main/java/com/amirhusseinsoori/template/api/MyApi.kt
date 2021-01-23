package com.amirhusseinsoori.template.api


import com.amirhusseinsoori.template.api.responses.response.DiverResponse

import retrofit2.Response
import retrofit2.http.*

interface MyApi {
    @GET("transactions")
    suspend fun getDetailsDiver(): Response<DiverResponse>


}
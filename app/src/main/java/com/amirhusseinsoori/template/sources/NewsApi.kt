package com.amirhusseinsoori.template.sources

import com.amirhusseinsoori.template.api.responses.response.SampleResponse
import com.example.template.api.safe.ApiWrapper

interface NewsApi {
    suspend fun fetchLatestNews(): SampleResponse
}
package com.example.testgpt_3.service

import com.example.testgpt_3.entity.CompletionData
import com.example.testgpt_3.entity.CompletionResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface CompletionService {
    @POST("chat/completions")
    suspend fun getCompletion(
        @Body completionData: CompletionData,
        @Header("Authorization") barer:String): CompletionResponse
}
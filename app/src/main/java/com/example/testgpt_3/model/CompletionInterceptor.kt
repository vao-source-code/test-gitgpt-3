package com.example.testgpt_3.model
import com.example.testgpt_3.RetrofitInstance
import com.example.testgpt_3.entity.CompletionData
import com.example.testgpt_3.entity.CompletionResponse
import com.example.testgpt_3.entity.Message
import com.example.testgpt_3.service.CompletionService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CompletionInterceptor {
    fun postCompletion(prompt: String, callback: (CompletionResponse) -> Unit) {
        val service = RetrofitInstance.getRetroInstance().create(CompletionService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            try {
                var message = Message(
                    content = prompt,
                    role = "user"
                )
                val data = CompletionData(
                    List(1) { message },
                    "gpt-3.5-turbo"
                )
                val response = service.getCompletion(data,"Bearer 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")
                callback(response)
            } catch (e: Exception) {
                (e as? HttpException)?.let {

                }
            }
        }
    }

}
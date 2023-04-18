package com.example.testgpt_3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testgpt_3.entity.CompletionResponse
import com.example.testgpt_3.model.CompletionInterceptor

class CompletionViewModel: ViewModel() {
    private  var interceptor: CompletionInterceptor = CompletionInterceptor()
    private  var completionLiveData: MutableLiveData<CompletionResponse> = MutableLiveData()

    fun observeCompletionLiveData(): MutableLiveData<CompletionResponse> {
        return completionLiveData
    }

    fun postCompletionLiveData(promt:String) {
        interceptor.postCompletion(promt){
            completionLiveData.postValue(it)
        }
    }

}
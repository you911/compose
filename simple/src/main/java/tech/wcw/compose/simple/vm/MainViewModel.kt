package tech.wcw.compose.simple.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import tech.wcw.compose.base.BaseViewModel
import tech.wcw.compose.simple.api.ApiService
import tech.wcw.compose.simple.model.NewsItem
import tech.wcw.support.retrofit
import tech.wcw.support.service
import tech.wcw.support.utils.LogUtils

class MainViewModel : BaseViewModel() {
    val newsResult = mutableStateListOf<NewsItem>()
    val errorMsg = mutableStateOf<String?>(null)
    val TAG = "MainViewModel"
    override fun onCreate() {
        LogUtils.i(TAG, "onCreate")
    }


    override fun onPause() {
        LogUtils.i(TAG, "onPause")
    }

    override fun onStart() {
        LogUtils.i(TAG, "onStart")
    }

    override fun onResume() {
        LogUtils.i(TAG, "onResume")
    }

    override fun onStop() {
        LogUtils.i(TAG, "onStop")
    }

    fun fetchData() {
        retrofit(
            request = { service(ApiService::class.java).news("top", 1) },
            success = {
                if (it.isSuccess() && it.result != null) {
                    newsResult.addAll(it.result.data)
                } else {
                    errorMsg.value = it.reason
                }
            }
        )
    }

    fun clearData() {
        newsResult.clear()
    }

}
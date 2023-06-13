package tech.wcw.compose.simple.api

import retrofit2.http.GET
import retrofit2.http.Query
import tech.wcw.compose.simple.model.NewsResult

interface ApiService {
    @GET("toutiao/index")
    suspend fun news(
        @Query("type") type: String,
        @Query("page") page: Int,
        @Query("key") key: String = "b5f53b06e299858467c008334604cf8b"
    ): NewsResult
}
package ir.shahabazimi.tetrisapi.network

import ir.shahabazimi.tetrisapi.models.TetrisResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetworkApi {

    @GET("repositories")
    suspend fun getTetris(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") size: Int
    ): TetrisResponse

}



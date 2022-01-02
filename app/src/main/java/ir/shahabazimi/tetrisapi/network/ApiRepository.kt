package ir.shahabazimi.tetrisapi.network

import javax.inject.Inject


class ApiRepository @Inject constructor(private val api: NetworkApi) : BaseRepository() {


    suspend fun getTetris(page:Int,size:Int) = safeApiCall {
        api.getTetris(
            "tetris",
            page,
            size
        )
    }

}
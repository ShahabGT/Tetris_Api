package ir.shahabazimi.tetrisapi.network


class ApiRepository(private val api: NetworkApi) : BaseRepository() {


    suspend fun getTetris(page:Int,size:Int) = safeApiCall {
        api.getTetris(
            "tetris",
            page,
            size
        )
    }

}
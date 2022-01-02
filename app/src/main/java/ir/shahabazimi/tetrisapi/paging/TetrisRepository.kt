package ir.shahabazimi.tetrisapi.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import ir.shahabazimi.tetrisapi.network.ApiRepository

class TetrisRepository(private val apiRepository: ApiRepository) {

    fun getTetris()=
        Pager(
            config = PagingConfig(
                pageSize = 30,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {PairPagingSource(apiRepository)}
        ).liveData

}
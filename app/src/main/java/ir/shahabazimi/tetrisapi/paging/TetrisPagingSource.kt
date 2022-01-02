package ir.shahabazimi.tetrisapi.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.shahabazimi.tetrisapi.models.TetrisItem
import ir.shahabazimi.tetrisapi.network.ApiRepository
import ir.shahabazimi.tetrisapi.network.Resource

private const val PAGE = 0

class PairPagingSource(private val apiRepository: ApiRepository) :
    PagingSource<Int, TetrisItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TetrisItem> {
        val position = params.key ?: PAGE
        return when (val res = apiRepository.getTetris(position, params.loadSize)) {
            is Resource.Success -> {
                LoadResult.Page(
                    data = res.value.items,
                    nextKey = if (res.value.items.isNullOrEmpty()) null else position + params.loadSize,
                    prevKey = if (position == PAGE) null else position - params.loadSize
                )
            }
            is Resource.Failure -> {
                LoadResult.Error(res.throwable ?: Exception())
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TetrisItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}
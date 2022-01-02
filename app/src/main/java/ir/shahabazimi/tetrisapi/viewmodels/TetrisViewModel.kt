package ir.shahabazimi.tetrisapi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import ir.shahabazimi.tetrisapi.network.ApiRepository
import ir.shahabazimi.tetrisapi.paging.TetrisRepository
import javax.inject.Inject

class TetrisViewModel @Inject constructor(
    apiRepository: ApiRepository
) :
    ViewModel() {
    private val tetrisRepository =
        TetrisRepository(apiRepository)

    val tetrisResponse = tetrisRepository.getTetris().cachedIn(viewModelScope)

}
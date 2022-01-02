package ir.shahabazimi.tetrisapi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import ir.shahabazimi.tetrisapi.network.ApiRepository
import ir.shahabazimi.tetrisapi.paging.TetrisRepository

class TetrisViewModel(
apiRepository: ApiRepository
) :
    ViewModel() {
    private val tetrisRepository =
        TetrisRepository(apiRepository)

//    private val _tetrisRepository: MutableLiveData<Resource<RodiniaUpdateProto.GetWalletTransactionsResponse>> =
//        MutableLiveData()

    val tetrisResponse = tetrisRepository.getTetris().cachedIn(viewModelScope)

}
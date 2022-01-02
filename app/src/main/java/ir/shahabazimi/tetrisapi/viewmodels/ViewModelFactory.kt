package ir.shahabazimi.tetrisapi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.shahabazimi.tetrisapi.network.ApiRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val apiRepository: ApiRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TetrisViewModel::class.java) -> TetrisViewModel(
                apiRepository
            ) as T

            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
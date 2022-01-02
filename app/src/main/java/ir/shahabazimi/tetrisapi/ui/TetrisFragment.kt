package ir.shahabazimi.tetrisapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import ir.shahabazimi.tetrisapi.R
import ir.shahabazimi.tetrisapi.adapters.TetrisAdapter
import ir.shahabazimi.tetrisapi.adapters.TetrisLoadStateAdapter
import ir.shahabazimi.tetrisapi.databinding.FragmentTetrisBinding
import ir.shahabazimi.tetrisapi.network.ApiRepository
import ir.shahabazimi.tetrisapi.network.NetworkApi
import ir.shahabazimi.tetrisapi.network.RemoteDataSource
import ir.shahabazimi.tetrisapi.viewmodels.TetrisViewModel
import ir.shahabazimi.tetrisapi.viewmodels.ViewModelFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TetrisFragment : Fragment() {

    private lateinit var b:FragmentTetrisBinding
    private lateinit var viewModel: TetrisViewModel
    private lateinit var adapter: TetrisAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b= FragmentTetrisBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val factory = ViewModelFactory(
            ApiRepository(RemoteDataSource().getApi(NetworkApi::class.java)),
        )
        adapter=TetrisAdapter()
        b.tetrisRecycler.setHasFixedSize(true)
        b.tetrisRecycler.adapter=adapter.withLoadStateFooter(
            footer = TetrisLoadStateAdapter { adapter.retry() }
        )

        viewModel = ViewModelProvider(this, factory).get(TetrisViewModel::class.java)

        viewModel.tetrisResponse.observe(viewLifecycleOwner, {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        })

    }

}
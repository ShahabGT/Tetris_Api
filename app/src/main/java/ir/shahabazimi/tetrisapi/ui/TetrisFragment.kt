package ir.shahabazimi.tetrisapi.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ir.shahabazimi.tetrisapi.adapters.TetrisAdapter
import ir.shahabazimi.tetrisapi.adapters.TetrisLoadStateAdapter
import ir.shahabazimi.tetrisapi.databinding.FragmentTetrisBinding
import ir.shahabazimi.tetrisapi.viewmodels.TetrisViewModel
import javax.inject.Inject

class TetrisFragment : Fragment() {

    private lateinit var b: FragmentTetrisBinding
    @Inject
    lateinit var viewModel: TetrisViewModel
    private lateinit var tetrisAdapter: TetrisAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentTetrisBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        tetrisAdapter = TetrisAdapter()
        b.tetrisRecycler.apply {
            setHasFixedSize(true)
            adapter = tetrisAdapter.withLoadStateFooter(
                footer = TetrisLoadStateAdapter { tetrisAdapter.retry() }
            )
        }

        viewModel.tetrisResponse.observe(viewLifecycleOwner, {
            tetrisAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        })
    }
}
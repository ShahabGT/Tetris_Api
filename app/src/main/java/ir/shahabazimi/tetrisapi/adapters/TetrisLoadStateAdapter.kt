package ir.shahabazimi.tetrisapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.shahabazimi.tetrisapi.databinding.RowTetrisFooterBinding

class TetrisLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<TetrisLoadStateAdapter.LoadStateViewHolder>() {

    inner class LoadStateViewHolder(private val v: RowTetrisFooterBinding) :
        RecyclerView.ViewHolder(v.root) {
        init {
            v.rowPairsRetry.setOnClickListener { retry }
        }

        fun bind(loadState: LoadState) {
            v.rowPairsError.text = "error"
            when (loadState) {
                is LoadState.Loading -> {
                    v.rowPairsError.visibility = View.GONE
                    v.rowPairsRetry.visibility = View.GONE
                    v.rowPairsLoading.visibility = View.VISIBLE
                }
                is LoadState.Error -> {
                    v.rowPairsError.visibility = View.VISIBLE
                    v.rowPairsRetry.visibility = View.VISIBLE
                    v.rowPairsLoading.visibility = View.GONE
                }
                else -> {
                    v.rowPairsError.visibility = View.VISIBLE
                    v.rowPairsRetry.visibility = View.VISIBLE
                    v.rowPairsLoading.visibility = View.GONE
                }
            }
        }
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) =
        LoadStateViewHolder(
            RowTetrisFooterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

}
package ir.shahabazimi.tetrisapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.shahabazimi.tetrisapi.databinding.TetrisRowBinding
import ir.shahabazimi.tetrisapi.models.TetrisItem

class TetrisAdapter : PagingDataAdapter<TetrisItem, TetrisAdapter.ViewHolder>(PAIR_COMPARATOR) {
    companion object {
        private val PAIR_COMPARATOR = object : DiffUtil.ItemCallback<TetrisItem>() {
            override fun areItemsTheSame(oldItem: TetrisItem, newItem: TetrisItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TetrisItem, newItem: TetrisItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val v: TetrisRowBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(model: TetrisItem) {
            v.rowTetrisId.text = model.id.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(TetrisRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(h: ViewHolder, position: Int) {
        val model = getItem(position)
        if (model != null)
            h.bind(model)

    }
}
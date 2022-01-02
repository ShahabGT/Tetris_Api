package ir.shahabazimi.tetrisapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.shahabazimi.tetrisapi.R
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
            val ctx = v.root.context
            if (model.has_wiki) {
                v.rowTetrisRoot.setCardBackgroundColor(
                    ctx.resources.getColor(
                        R.color.md_theme_light_secondaryContainer,
                        null
                    )
                )
                v.rowTetrisWiki.visibility = View.GONE
            } else {
                v.rowTetrisRoot.setCardBackgroundColor(
                    ctx.resources.getColor(
                        R.color.md_theme_light_errorContainer,
                        null
                    )
                )
                v.rowTetrisWiki.visibility = View.VISIBLE
            }

            v.rowTetrisName.text = model.name

            v.rowTetrisLoginName.text =
                ctx.getString(R.string.repo_dev, model.owner.login)

            v.rowTetrisRepoSize.text =
                ctx.getString(R.string.repo_size, model.size)

            v.rowTetrisAvatar.setImageURI(model.owner.avatar_url)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TetrisRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(h: ViewHolder, position: Int) {
        val model = getItem(position)
        if (model != null)
            h.bind(model)

    }
}
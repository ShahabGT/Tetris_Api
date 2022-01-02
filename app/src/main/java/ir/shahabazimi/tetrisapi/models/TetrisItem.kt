package ir.shahabazimi.tetrisapi.models

data class TetrisItem(
    val has_wiki: Boolean,
    val id: Int,
    val name: String,
    val owner: TetrisItemOwner,
    val size: Int,
)
package ir.shahabazimi.tetrisapi.models

data class TetrisResponse(
    val incomplete_results: Boolean,
    val items: List<TetrisItem>,
    val total_count: Int
)
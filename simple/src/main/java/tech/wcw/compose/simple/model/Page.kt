package tech.wcw.compose.simple.model

class Page<T>(
    val stat: Int, val data: List<T>,
    val page: Int,
    val pageSize: Int
) {
}
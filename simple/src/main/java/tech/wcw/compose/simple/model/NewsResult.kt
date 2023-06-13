package tech.wcw.compose.simple.model

import tech.wcw.support.net.ResultInterface


class NewsResult(val errorCode: Int, val reason: String, val result: Page<NewsItem>?) :
    ResultInterface<NewsItem> {
    override fun isSuccess(): Boolean {
        return errorCode == 0
    }

}

data class NewsItem(
    val uniquekey: String,
    val title: String,
    val date: String,
    val category: String,
    val author_name: String,
    val url: String,
    val thumbnail_pic_s: String,
    val is_content: String,
)


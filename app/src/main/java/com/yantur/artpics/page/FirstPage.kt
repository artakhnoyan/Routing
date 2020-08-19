package com.yantur.artpics.page

import android.content.Context
import android.content.Intent
import com.yantur.artpics.activity.FirstActivity

class FirstPage(
    context: Context, source: String,
    private val firstRequestData: FirstRequestData
) : Page(context, source) {

    override fun getIntentForScreen(): Intent {
        return Intent(context, FirstActivity::class.java).apply {
            putExtra("pics_count", firstRequestData.picsCount)
        }
    }
}

data class FirstRequestData(
    val picsCount: Int
)

data class FirstPageResult(val status: String?) : PageResult
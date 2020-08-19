package com.yantur.artpics.page

import android.content.Context
import android.content.Intent

abstract class ResultPage<out T : PageResult>(
    context: Context,
    source: String
) : Page(context, source) {
    abstract fun handleResult(intent: Intent?): T
}

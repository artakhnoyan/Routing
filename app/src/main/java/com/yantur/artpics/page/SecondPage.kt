package com.yantur.artpics.page

import android.content.Context
import android.content.Intent
import com.yantur.artpics.activity.SecondActivity

    class SecondPage(context: Context, source: String) :
        ResultPage<SecondPagePageResult>(context, source) {

        override fun getIntentForScreen(): Intent {
            return Intent(context, SecondActivity::class.java)
        }

        override fun handleResult(intent: Intent?): SecondPagePageResult =
            SecondPagePageResult(
                intent?.getStringExtra("status") ?: ""
            )
    }

data class SecondPagePageResult(val status: String?) : PageResult
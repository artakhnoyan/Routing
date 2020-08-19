package com.yantur.artpics.page

import android.content.Context
import android.content.Intent


abstract class Page(context: Context, val source: String) {
    protected val context: Context = context.applicationContext
    abstract fun getIntentForScreen(): Intent
}
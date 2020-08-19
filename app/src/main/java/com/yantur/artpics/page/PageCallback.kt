package com.yantur.artpics.page

import com.yantur.artpics.activity.BaseActivity

interface PageCallback<in T: PageResult> {
    fun onResult(activity: BaseActivity?, result: T)
}



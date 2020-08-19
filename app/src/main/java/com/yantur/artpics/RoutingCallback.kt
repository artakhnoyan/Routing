package com.yantur.artpics

import android.content.Intent
import androidx.fragment.app.Fragment
import com.yantur.artpics.activity.BaseActivity
import com.yantur.artpics.page.Page
import com.yantur.artpics.page.PageCallback
import com.yantur.artpics.page.PageResult
import com.yantur.artpics.page.ResultPage

interface RoutingCallback {
    fun navigateTo(fragment: Fragment, page: Page)

    fun <T : PageResult> navigateTo(
        fragment: Fragment,
        page: ResultPage<PageResult>,
        pageCallback: PageCallback<T>
    )

    fun handleResult(activity: BaseActivity, requestCode: Int, resultCode: Int, data: Intent?)

    fun <T : PageResult> registerCallback(pageCallback: PageCallback<T>)
}
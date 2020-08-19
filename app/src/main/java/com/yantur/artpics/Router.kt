package com.yantur.artpics

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.yantur.artpics.activity.BaseActivity
import com.yantur.artpics.page.Page
import com.yantur.artpics.page.PageCallback
import com.yantur.artpics.page.PageResult
import com.yantur.artpics.page.ResultPage
import java.lang.ref.WeakReference

private const val REQUEST_CODE = 1

class Router(activity: BaseActivity) {

    private var weakActivity = WeakReference(activity)

    private var page: ResultPage<PageResult>? = null

    private var block: PageCallback<PageResult>? = null

    fun navigateTo(activity: FragmentActivity, page: Page) {
        activity.startActivity(page.getIntentForScreen())
    }

    fun navigateTo(activity: FragmentActivity, page: ResultPage<PageResult>) {
        this.page = page
        activity.startActivityForResult(page.getIntentForScreen(), REQUEST_CODE)
    }

    fun navigateTo(fragment: Fragment, page: Page) {
        fragment.startActivity(page.getIntentForScreen())
    }

    fun navigateTo(fragment: Fragment, page: ResultPage<PageResult>) {
        this.page = page
        fragment.startActivityForResult(page.getIntentForScreen(), REQUEST_CODE)
    }

    fun handleResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                page?.handleResult(data)?.let {
                    block?.onResult(weakActivity.get(), it)
                }
            }
        }
        resetRouter()
    }

    fun setActivity(activity: BaseActivity) {
        weakActivity = WeakReference(activity)
    }

    private fun resetRouter() {
        block = null
        page = null
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : PageResult> registerCallback(pageCallback: PageCallback<T>) {
        block = pageCallback as PageCallback<PageResult>
    }
}



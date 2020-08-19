package com.yantur.artpics.fragment

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.yantur.artpics.RoutingCallback
import com.yantur.artpics.activity.BaseActivity
import com.yantur.artpics.page.Page
import com.yantur.artpics.page.PageCallback
import com.yantur.artpics.page.PageResult
import com.yantur.artpics.page.ResultPage

abstract class BaseFragment : Fragment() {

    private var routingCallback: RoutingCallback? = null

    protected fun navigate(page: Page) {
        routingCallback?.navigateTo(this, page)
    }

    protected fun <T: PageResult> navigateWithResult(
        page: ResultPage<PageResult>,
        pageCallback: PageCallback<T>
    ) {
        routingCallback?.navigateTo(this, page, pageCallback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        routingCallback?.handleResult(activity as BaseActivity, requestCode, resultCode, data)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is RoutingCallback) {
            routingCallback = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        routingCallback = null
    }
}
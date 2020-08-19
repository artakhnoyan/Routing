package com.yantur.artpics.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.yantur.artpics.Navigator
import com.yantur.artpics.Router
import com.yantur.artpics.RoutingCallback
import com.yantur.artpics.page.Page
import com.yantur.artpics.page.PageCallback
import com.yantur.artpics.page.PageResult
import com.yantur.artpics.page.ResultPage

abstract class BaseActivity : FragmentActivity(), RoutingCallback {

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lastRouter = Navigator.getLastResultRouter()
        if (savedInstanceState != null && lastRouter != null) {
            router = lastRouter
            router.setActivity(this)
            Navigator.removeLastResultRouter()
        } else {
            router = Router(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        handleResult(this, requestCode, resultCode, data)
    }

    protected fun <T : PageResult> navigateWithResult(
        page: ResultPage<PageResult>,
        pageCallback: PageCallback<T>
    ) {
        router.navigateTo(this, page)
        registerCallback(pageCallback)
    }

    protected fun navigate(page: Page) {
        router.navigateTo(this, page)
    }

    protected fun setOKResult(intent: Intent?) {
        setResult(Activity.RESULT_OK, intent)
    }

    protected fun finishActivity() {
        finish()
    }

    override fun <T : PageResult> registerCallback(pageCallback: PageCallback<T>) {
        router.registerCallback(pageCallback)
        Navigator.addResultRouter(router)
    }

    override fun navigateTo(fragment: Fragment, page: Page) {
        router.navigateTo(fragment, page)
    }

    override fun <T : PageResult> navigateTo(
        fragment: Fragment,
        page: ResultPage<PageResult>,
        pageCallback: PageCallback<T>
    ) {
        router.navigateTo(fragment, page)
        registerCallback(pageCallback)
    }

    override fun handleResult(
        activity: BaseActivity,
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        router.handleResult(requestCode, resultCode, data)
    }
}

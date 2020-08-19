package com.yantur.artpics.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yantur.artpics.R
import com.yantur.artpics.activity.BaseActivity
import com.yantur.artpics.page.PageCallback
import com.yantur.artpics.page.SecondPage
import com.yantur.artpics.page.SecondPagePageResult
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        push_free.setOnClickListener {
            val secondPage = SecondPage(requireContext(), "first")
            navigateWithResult(
                secondPage,
                object : PageCallback<SecondPagePageResult> {
                    override fun onResult(activity: BaseActivity?, result: SecondPagePageResult) {
                        // handle result here
                    }
                })
        }
    }
}
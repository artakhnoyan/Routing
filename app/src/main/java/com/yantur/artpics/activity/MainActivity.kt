package com.yantur.artpics.activity

import android.os.Bundle
import com.yantur.artpics.R
import com.yantur.artpics.page.FirstPage
import com.yantur.artpics.page.FirstRequestData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        push.setOnClickListener {

            val firstPage = FirstPage(
                applicationContext,
                "main_activity",
                FirstRequestData(10)
            )

            navigate(firstPage)
        }
    }

}
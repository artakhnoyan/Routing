package com.yantur.artpics.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.yantur.artpics.R

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Handler().postDelayed({
            val intent = Intent()
            setOKResult(intent)
            finishActivity()
        }, 3000)
    }
}
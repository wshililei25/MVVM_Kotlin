package com.flower

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.flower.base.room.RoomUtils
import com.flower.user.ui.activity.LoginActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        mTv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@StartActivity, LoginActivity::class.java))
            }

        })
    }

    override fun onResume() {
        super.onResume()
        var userInfo = RoomUtils.getUserInfo(this)
        userInfo?.let {
            if (null != userInfo) {
                mTv.text = userInfo!!.nickname
            }
        }

    }
}

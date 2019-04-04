package com.flower.user.ui.activity

import android.os.Bundle
import com.flower.base.room.RoomUtils
import com.flower.user.BR
import com.flower.user.R
import com.flower.user.databinding.UserActivityLoginBinding
import com.flower.user.ui.model.LoginViewModel
import com.yizhipin.base.ext.enable
import kotlinx.android.synthetic.main.user_activity_login.*
import me.goldze.mvvmhabit.base.BaseActivity

/**
 *  @author: XiLei  @date: 2019/3/28
 */
class LoginActivity : BaseActivity<UserActivityLoginBinding, LoginViewModel>() {

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.user_activity_login
    }

    override fun initVariableId(): Int {
        return BR.mViewModel
    }

    override fun initData() {
        mLoginBtn.enable(mMobileEt, { isBtnEnable() })
        mLoginBtn.enable(mPswEt, { isBtnEnable() })

        var userInfo = RoomUtils.getUserInfo(getApplication())
        userInfo?.let {
            viewModel.mPhone.set(userInfo.mobile)
//            mMobileEt.setSelection(11)
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPswEt.text.isNullOrEmpty().not()
    }
}
package com.flower.user.ui.model

import android.app.Application
import android.databinding.ObservableField
import com.flower.base.data.net.RetrofitFactoryPost
import com.flower.base.data.response.UserInfo
import com.flower.base.presenter.view.BaseView
import com.flower.base.room.UserRoomDatabase
import com.flower.base.rx.BaseSubscriber
import com.flower.user.data.api.UserApi
import com.yizhipin.base.ext.convert
import com.yizhipin.base.ext.execute
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import me.goldze.mvvmhabit.base.BaseViewModel
import me.goldze.mvvmhabit.binding.command.BindingAction
import me.goldze.mvvmhabit.binding.command.BindingCommand
import org.jetbrains.anko.toast


/**
 *  @author: XiLei  @date: 2019/3/28
 */
class LoginViewModel(application: Application) : BaseViewModel(application) {

    //手机号绑定
    var mPhone = ObservableField<String>()
    //密码绑定
    var mPwd = ObservableField<String>()

    override fun onCreate() {

    }

    var mLoginClickCommand = BindingCommand<Any>(BindingAction {
        login(application)
    })

    private fun login(application: Application) {
        var map = mutableMapOf<String, String>()
        map.put("mobile", mPhone.get().toString().trim())
        map.put("password", mPwd.get().toString().trim())
        map.put("deviceToken", "")
        map.put("deviceType", "android")
        map.put("type", "0")
        showDialog()
        RetrofitFactoryPost(map).create(UserApi::class.java).login().convert()
            .execute(object : BaseSubscriber<UserInfo>(object : BaseView {

                override fun hideLoading() {
                    dismissDialog()
                }

                override fun onError(mes: String) {
                    application.toast(mes)
                }

            }) {
                override fun onNext(t: UserInfo) {
                    Observable.just("")
                        .subscribeOn(Schedulers.io())
                        .subscribe { db ->
                            UserRoomDatabase.getDatabase(application).userDao().insert(t)
                        }

                    finish()
                }
            }, lifecycleProvider)
    }
}
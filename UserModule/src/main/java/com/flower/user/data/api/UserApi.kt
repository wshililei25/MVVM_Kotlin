package com.flower.user.data.api

import com.flower.base.data.response.UserInfo
import com.flower.user.data.protocol.BaseResp
import com.yizhipin.usercenter.data.api.Api
import io.reactivex.Observable
import retrofit2.http.POST


/**
 * Created by ${XiLei} on 2018/7/27.
 */
interface UserApi {

    @POST(Api.LOGIN) //登录
    fun login(): Observable<BaseResp<UserInfo>>

}
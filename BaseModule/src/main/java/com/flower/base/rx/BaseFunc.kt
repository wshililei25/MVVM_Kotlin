package com.flower.base.rx

import com.flower.base.common.BaseResultCode
import com.flower.user.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by ${XiLei} on 2018/8/5.
 * 无分页数据时使用
 */
class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        if (!t.code.equals(BaseResultCode.SUCCESS)) {
            return Observable.error(BaseException(t.code, t.msg, t.data))
        }

        if (t.data == null) {
            return Observable.error(DataNullException())
        }
        return Observable.just(t.data)
    }
}
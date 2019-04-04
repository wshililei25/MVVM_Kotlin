package com.flower.base.presenter.view

/**
 * Created by ${XiLei} on 2018/7/26.
 */
interface BaseView {

    fun hideLoading()
    fun onError(mes: String)
    fun onDataIsNull(){}//默认实现
}
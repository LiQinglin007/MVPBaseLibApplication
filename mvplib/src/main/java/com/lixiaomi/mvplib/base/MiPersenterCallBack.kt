package com.lixiaomi.mvplib.base

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/10/14<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
abstract class MiPersenterCallBack(private val view: BaseView) : BasePresenterCallBack {
    override fun error(message: String?) {
        view.showToast(message)
    }

    override fun finish() {
        view.stopLoading()
    }
}
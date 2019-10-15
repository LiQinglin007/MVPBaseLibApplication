package com.lixiaomi.mvplib.base

import com.lixiaomi.baselib.config.AppConfigInIt
import com.lixiaomi.baselib.config.AppConfigType
import com.lixiaomi.baselib.net.HttpConfig
import com.lixiaomi.baselib.net.okhttp.BaseOkHttpCallBack
import com.lixiaomi.baselib.utils.LogUtils
import com.lixiaomi.baselib.utils.MiJsonUtil
import com.lixiaomi.baselib.utils.NetWorkUtils
import com.lixiaomi.mvplib.R

/**
 * @describe：<br>
 * @author：Xiaomi<br>
 * @createTime：2019/10/14<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
abstract class MiHttpCallBack(var myPresenterCallBack: BasePresenterCallBack) : BaseOkHttpCallBack() {
    override fun onSuccess(code: Int, url: String, response: String) {
        var httpConfig = (AppConfigInIt.getConfiguration(AppConfigType.HTTP_CONFIG) as HttpConfig)
        if (code == httpConfig.tokeN_TIME_OUT_CODE) {
            onError(httpConfig.tokeN_TIME_OUT_STR)
            onFinish()
            return
        }
        if (code != httpConfig.httP_SUCCESS_CODE) {
            onError(AppConfigInIt.getApplicationContext().resources.getString(R.string.http_ServiceError))
            onFinish()
            return
        }
        val urlList = MiJsonUtil.getJson(
                AppConfigInIt.getConfiguration<HttpConfig>(AppConfigType.HTTP_CONFIG).interceptoR_URL_LIST)
        LogUtils.loge("url${url}")
        LogUtils.loge("urlList${urlList}")
        if (!urlList.contains(url.substring(0,url.length-1))) {
            if (response.contains(httpConfig.serveR_ERROR_STR)) {
                onError(AppConfigInIt.getApplicationContext().resources.getString(R.string.http_ServiceError))
                onFinish()
                return
            }
        }
        onSuccess(response)
        onFinish()
    }

    override fun onFailure(e: Throwable?) {
        LogUtils.loge("请求报错了：${e.toString()}")
        onError(AppConfigInIt.getApplicationContext().resources.getString(if (NetWorkUtils.isNetworkConnected(AppConfigInIt.getApplicationContext())) {
            R.string.http_onFailure
        } else {
            R.string.http_NoNetWorkError
        }))
        onFinish()
    }

    /**
     * 请求成功
     */
    abstract fun onSuccess(response: String)

    /**
     * 请求成功，但是报错了
     */
    private fun onError(message: String) {
        myPresenterCallBack.error(message)
    }

    /**
     * 请求结束
     */
    private fun onFinish() {
        myPresenterCallBack.finish()
    }
}
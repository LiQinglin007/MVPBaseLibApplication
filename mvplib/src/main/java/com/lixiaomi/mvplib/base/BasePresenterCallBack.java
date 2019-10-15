package com.lixiaomi.mvplib.base;

/**
 * @describe：model请求后的回调<br>
 * @author：Xiaomi<br>
 * @createTime：2019/4/2<br>
 * @remarks：<br>
 * @changeTime:<br>
 */
public interface BasePresenterCallBack {
    /**
     * 请求成功
     *
     * @param response
     */
    void success(String response);

    /**
     * 出现错误
     * 在onResponse方法中，例如出现"<html>"等问题，在该方法中返回
     * 或者请求失败
     *
     * @param message
     */
    void error(String message);


    /**
     * 结束
     */
    void finish();
}

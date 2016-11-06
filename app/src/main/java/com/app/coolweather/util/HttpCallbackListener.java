package com.app.coolweather.util;

/**
 * Created by 王驰 on 2016-11-04.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}

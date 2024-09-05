package com.example.flutter_dajia_sdk04;

import android.app.Application;

import com.innovation.animal.breedfunctionsdk.SDK;

/**
 * @Author : wenhaiyang
 * @Date : 2024/9/4
 * @Name : MyApp
 * @Desc:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化SDK
        SDK.init(this);
    }
}

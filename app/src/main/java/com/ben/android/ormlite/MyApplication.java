package com.ben.android.ormlite;

import android.app.Application;

import com.ben.android.ormlite.db_framework.ORMLite;
import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ORMLite.init(this,new ORMLiteConfiguration.Builder()
                .cache(true)
                .build());
    }
}

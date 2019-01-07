package com.ben.android.ormlite.db_framework;

import android.os.Environment;

public class DBConstants {
    public static final String DEFAULT_DB_DIRECTORY = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String DEFAULT_DB_NAME = "ormlite.db";
    public static final String DB_TAG = "ormlite";
}

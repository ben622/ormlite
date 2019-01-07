package com.ben.android.ormlite.db_framework.dbcore;


import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

import java.io.File;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public class SQLiteDatabaseFactory {
    public static synchronized SQLiteDatabase openOrCreateDatabase(ORMLiteConfiguration configuration) {
        return SQLiteDatabase.openOrCreateDatabase(new File(configuration.getBuilder().getDbDirectory(), configuration.getBuilder().getDbName()), null);
    }
}

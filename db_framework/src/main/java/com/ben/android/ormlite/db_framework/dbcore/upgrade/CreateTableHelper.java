package com.ben.android.ormlite.db_framework.dbcore.upgrade;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;
import com.ben.android.ormlite.db_framework.dbcore.IDBHelper;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
class CreateTableHelper implements IDBHelper {
    @Override
    public void execSQL(SQLiteDatabase database, AnnotationModel annotationModel) {
    }
}

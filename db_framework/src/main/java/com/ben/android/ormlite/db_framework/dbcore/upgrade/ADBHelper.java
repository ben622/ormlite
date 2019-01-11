package com.ben.android.ormlite.db_framework.dbcore.upgrade;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;
import com.ben.android.ormlite.db_framework.dbcore.IDBHelper;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc 程序对数据库表的操作进行日志记录，以提供对数据库版本自动更新支持
 */
abstract class ADBHelper<T> implements IDBHelper<T>{
    @Override
    public void execSQL(DBModel model, T t) {

    }
}

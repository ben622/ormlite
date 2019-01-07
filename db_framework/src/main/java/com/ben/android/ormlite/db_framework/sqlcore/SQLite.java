package com.ben.android.ormlite.db_framework.sqlcore;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.IORMLite;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public interface SQLite<T>{
    long insert(SQLiteDatabase database,String sql);

    int delete(SQLiteDatabase database,String sql);

    int update(SQLiteDatabase database,String sql);

    List<T> query(SQLiteDatabase database,String sql);
}

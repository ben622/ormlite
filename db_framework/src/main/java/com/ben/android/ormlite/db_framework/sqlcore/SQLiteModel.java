package com.ben.android.ormlite.db_framework.sqlcore;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.dbcore.DBModel;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/8
 */
public class SQLiteModel<T> extends ASQLiteModel {

    public SQLiteModel(SQLiteDatabase database) {
        super(database);
    }

    @Override
    public void execuSql() {

    }

    @Override
    public long insert() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findLast() {
        return null;
    }

    @Override
    public Object findFirst() {
        return null;
    }

    @Override
    public long update() {
        return 0;
    }
}

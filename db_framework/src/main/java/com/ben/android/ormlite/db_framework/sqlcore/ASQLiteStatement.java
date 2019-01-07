package com.ben.android.ormlite.db_framework.sqlcore;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.IORMLite;

import java.util.List;

public final class ASQLiteStatement<T> implements SQLite<T> {

    @Override
    public long insert(SQLiteDatabase database, String sql) {
        return 0;
    }

    @Override
    public int delete(SQLiteDatabase database, String sql) {
        return 0;
    }

    @Override
    public int update(SQLiteDatabase database, String sql) {
        return 0;
    }

    @Override
    public List<T> query(SQLiteDatabase database, String sql) {
        return null;
    }
}

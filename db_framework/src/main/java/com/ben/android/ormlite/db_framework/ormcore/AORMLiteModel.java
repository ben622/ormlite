package com.ben.android.ormlite.db_framework.ormcore;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.dbcore.DBModel;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/8
 */
public abstract class AORMLiteModel<T> extends DBModel<T> {
    public AORMLiteModel(SQLiteDatabase database) {
        super(database);
    }

    @Override
    public long insert() {
        return getDatabase().insert(getAnnotationModel().getTable().value(), null, getContentValues());
    }

    @Override
    public int delete() {
        return getDatabase().delete(getAnnotationModel().getTable().value(), getWhereClause(), getWhereArgs());
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

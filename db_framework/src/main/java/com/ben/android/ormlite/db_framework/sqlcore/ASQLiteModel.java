package com.ben.android.ormlite.db_framework.sqlcore;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.dbcore.DBModel;
import com.ben.android.ormlite.db_framework.dbcore.operator.IDBRetrieveOperator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public abstract class ASQLiteModel extends DBModel implements IDBRetrieveOperator {
    public ASQLiteModel(SQLiteDatabase database) {
        super(database);
    }

    public abstract void execuSql();

}

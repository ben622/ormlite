package com.ben.android.ormlite.db_framework.dbcore;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;
import com.ben.android.ormlite.db_framework.dbcore.operator.IDBCreateOperator;
import com.ben.android.ormlite.db_framework.dbcore.operator.IDBDeleteOperator;
import com.ben.android.ormlite.db_framework.dbcore.operator.IDBModelOperator;
import com.ben.android.ormlite.db_framework.dbcore.operator.IDBRetrieveOperator;
import com.ben.android.ormlite.db_framework.dbcore.operator.IDBUpdateOperator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public abstract class DBModel<T> implements IDBModelOperator<T>,IDBCreateOperator,IDBDeleteOperator,IDBUpdateOperator,IDBRetrieveOperator{
    private SQLiteDatabase database;
    private AnnotationModel annotationModel;
    private ContentValues contentValues;
    private String whereClause;
    private String[] whereArgs;

    public DBModel(SQLiteDatabase database) {
        this.database = database;
    }

    public AnnotationModel getAnnotationModel() {
        return annotationModel;
    }

    public String getWhereClause() {
        return whereClause;
    }

    public String[] getWhereArgs() {
        return whereArgs;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public ContentValues getContentValues() {
        return contentValues;
    }

    @Override
    public IDBModelOperator<T> between(String fieldName, int from, int to) {
        return null;
    }

    @Override
    public IDBModelOperator<T> between(String fieldName, double from, double to) {
        return null;
    }

    @Override
    public IDBModelOperator<T> between(String fieldName, long from, long to) {
        return null;
    }

    @Override
    public IDBModelOperator<T> equalTo(String fieldName, String value) {
        return null;
    }

    @Override
    public IDBModelOperator<T> equalTo(String fieldName, int value) {
        return null;
    }

    @Override
    public IDBModelOperator<T> equalTo(String fieldName, long value) {
        return null;
    }

    @Override
    public IDBModelOperator<T> equalTo(String fieldName, double value) {
        return null;
    }

    @Override
    public IDBModelOperator<T> in(String fieldName, String... value) {
        return null;
    }
}

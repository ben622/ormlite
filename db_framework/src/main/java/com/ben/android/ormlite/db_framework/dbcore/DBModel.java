package com.ben.android.ormlite.db_framework.dbcore;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public abstract class DBModel<T,R>{
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


}

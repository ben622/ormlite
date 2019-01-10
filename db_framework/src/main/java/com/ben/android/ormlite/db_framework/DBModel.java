package com.ben.android.ormlite.db_framework;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public class DBModel {
    private SQLiteDatabase database;
    private ORMLiteConfiguration configuration;
    private AnnotationModel annotationModel;
    private ContentValues contentValues;
    private StringBuilder whereClause = new StringBuilder(" 1=1 ");
    private String[] whereArgs;

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }

    public ORMLiteConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ORMLiteConfiguration configuration) {
        this.configuration = configuration;
    }

    public AnnotationModel getAnnotationModel() {
        return annotationModel;
    }

    public void setAnnotationModel(AnnotationModel annotationModel) {
        this.annotationModel = annotationModel;
    }

    public ContentValues getContentValues() {
        return contentValues;
    }

    public void setContentValues(ContentValues contentValues) {
        this.contentValues = contentValues;
    }

    public StringBuilder getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(StringBuilder whereClause) {
        this.whereClause = whereClause;
    }

    public String[] getWhereArgs() {
        return whereArgs;
    }

    public void setWhereArgs(String[] whereArgs) {
        this.whereArgs = whereArgs;
    }
}

package com.ben.android.ormlite.db_framework;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public class DBModel {
    private SQLiteDatabase database;
    private ORMLiteConfiguration configuration;
    private AnnotationModel annotationModel;
    private ContentValues contentValues = new ContentValues();
    private StringBuilder whereClause = new StringBuilder(" 1=1 ");
    private List<String> whereArgs = new ArrayList<>();

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

    public<T> void setContentValues(T t) throws IllegalAccessException {
        contentValues.clear();
        List<AnnotationModel.ValueModel> valueModels = getAnnotationModel().getValueModels();
        for (AnnotationModel.ValueModel valueModel : valueModels) {
            Field field = valueModel.getField();
            field.setAccessible(true);
            Object value = field.get(t);
            if (value != null) {
                if (field.getType() == String.class) {
                    contentValues.put(valueModel.getValue(), (String) value);
                } else if (field.getType() == Integer.class) {
                    contentValues.put(valueModel.getValue(), (Integer) value);
                } else if (field.getType() == Double.class) {
                    contentValues.put(valueModel.getValue(), (Double) value);
                } else if (field.getType() == Float.class) {
                    contentValues.put(valueModel.getValue(), (Float) value);
                } else if (field.getType() == Boolean.class) {
                    contentValues.put(valueModel.getValue(), (Boolean) value);
                } else if (field.getType() == Long.class) {
                    contentValues.put(valueModel.getValue(), (Long) value);
                } else if (field.getType() == Byte[].class || field.getType() == Byte.class) {
                    contentValues.put(valueModel.getValue(), (byte[]) value);
                }
            }
        }
    }

    public StringBuilder getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(StringBuilder whereClause) {
        this.whereClause = whereClause;
    }

    public List<String> getWhereArgs() {
        return whereArgs;
    }

    public void setWhereArgs(List<String> whereArgs) {
        this.whereArgs = whereArgs;
    }

}

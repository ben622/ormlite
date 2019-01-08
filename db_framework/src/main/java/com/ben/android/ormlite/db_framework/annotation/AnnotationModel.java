package com.ben.android.ormlite.db_framework.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public class AnnotationModel {
    private Class<?> calss;
    private Field field;
    private Table table;
    private Column column;
    private String tableName;
    private String columnName;
    private String columnValue;




    public Class<?> getCalss() {
        return calss;
    }

    public void setCalss(Class<?> calss) {
        this.calss = calss;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}

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

    private boolean primaryKey;
    private boolean foreignKey;
    private String foreignTableName;
    private String foreignTableColumnName;

    private HashMap<String, String> columns = new HashMap<>();

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

    public HashMap<String, String> getColumns() {
        return columns;
    }

    public void setColumns(HashMap<String, String> columns) {
        this.columns = columns;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(boolean foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getForeignTableName() {
        return foreignTableName;
    }

    public void setForeignTableName(String foreignTableName) {
        this.foreignTableName = foreignTableName;
    }

    public String getForeignTableColumnName() {
        return foreignTableColumnName;
    }

    public void setForeignTableColumnName(String foreignTableColumnName) {
        this.foreignTableColumnName = foreignTableColumnName;
    }
}

package com.ben.android.ormlite.db_framework.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public class AnnotationModel {
    private Class<?> cls;
    private Table table;
    private String tableName;

    private List<ValueModel> valueModels;

    public AnnotationModel() {
        valueModels = new ArrayList<>();
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<ValueModel> getValueModels() {
        return valueModels;
    }

    public void setValueModels(List<ValueModel> valueModels) {
        this.valueModels = valueModels;
    }

    public static class ValueModel{
        private String value;
        private boolean primaryKey;

        private boolean foreignKey;
        private Class<?> foreignValue;

        private Field field;
        private Column column;
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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



        public Field getField() {
            return field;
        }

        public void setField(Field field) {
            this.field = field;
        }

        public Column getColumn() {
            return column;
        }

        public void setColumn(Column column) {
            this.column = column;
        }

        public Class<?> getForeignValue() {
            return foreignValue;
        }

        public void setForeignValue(Class<?> foreignValue) {
            this.foreignValue = foreignValue;
        }
    }
}

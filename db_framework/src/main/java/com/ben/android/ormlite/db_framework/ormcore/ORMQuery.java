package com.ben.android.ormlite.db_framework.ormcore;

import android.database.Cursor;
import android.text.TextUtils;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMQuery<T> extends AORMQuery<ORMQuery<T>, T> {
    private int start, end;
    private String orderByColumn = " autoincrement_id ", orderType = " ASC ";

    public ORMQuery(DBModel model) {
        super(model);
    }

    @Override
    public AORMQuery<ORMQuery<T>, T> orderBy(String column, String o) {
        this.orderByColumn = TextUtils.isEmpty(column) ? " autoincrement_id " : column;
        this.orderType = TextUtils.isEmpty(o) ? " ASC " : o;
        return this;
    }

    @Override
    public AORMQuery<ORMQuery<T>, T> limit(int start, int end) {
        this.start = start;
        this.end = end;
        return this;
    }

    @Override
    public List<T> findAll() {
        List<T> alls = new ArrayList<>();
        try {
            Cursor cursor = getModel().getDatabase().query(getModel().getAnnotationModel().getTableName(), null, getModel().getWhereClause().toString(), getModel().getWhereArgs().toArray(new String[getModel().getWhereArgs().size()]), null, null, orderByColumn + orderType, start == 0 && end == 0 ? null : start + "," + end);
            while (cursor.moveToNext()) {
                Object item = getModel().getAnnotationModel().getCls().newInstance();
                for (AnnotationModel.ValueModel valueModel : getModel().getAnnotationModel().getValueModels()) {
                    //get column name
                    int columnIndex = cursor.getColumnIndex(valueModel.getValue());
                    Field field = valueModel.getField();
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    if (fieldType == String.class) {
                        field.set(item, cursor.getString(columnIndex));
                    } else if (fieldType == Integer.class || "int".equals(fieldType.getName())) {
                        field.set(item, cursor.getInt(columnIndex));
                    } else if (fieldType == Long.class || "long".equals(fieldType.getName())) {
                        field.set(item, cursor.getLong(columnIndex));
                    } else if (fieldType == Double.class || "double".equals(field.getName())) {
                        field.set(item, cursor.getDouble(columnIndex));
                    } else if (fieldType == Float.class || "float".equals(field.getName())) {
                        field.set(item, cursor.getFloat(columnIndex));
                    } else if (fieldType == byte[].class || fieldType == Byte.class) {
                        field.set(item, cursor.getBlob(columnIndex));
                    }
                }

                alls.add((T) item);
            }
            cursor.close();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return alls;
    }

    @Override
    public T findLast() {
        orderType = " DESC ";
        this.start = 0;
        this.end = 1;
        List<T> ts = findAll();
        return ts.size() > 0 ? ts.get(0) : null;
    }

    @Override
    public T findFirst() {
        this.start = 0;
        this.end = 1;
        List<T> ts = findAll();
        return ts.size() > 0 ? ts.get(0) : null;
    }


}

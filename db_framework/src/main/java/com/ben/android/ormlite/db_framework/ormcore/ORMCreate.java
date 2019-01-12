package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMCreate<T> extends AORMCreate<ORMCreate, T> {
    private List<String> sqls;
    private List<List<Object>> values;
    private StringBuilder temp = new StringBuilder();


    public ORMCreate(DBModel model) {
        super(model);
        sqls = new ArrayList<>();
        values = new ArrayList<>();
    }
    @Override
    public AORMCreate<ORMCreate, T> one(T insert) {
        return mults(Arrays.asList(insert));
    }

    @Override
    public AORMCreate<ORMCreate, T> mults(List<T> inserts) {
        if (inserts == null) {
            throw new IllegalArgumentException("insert entitys not null!");
        }
        try {
            for (int i = 0; i < inserts.size(); i++) {
                T t = inserts.get(i);
                //Use StringBuilder builder
                getModel().getWhereClause().setLength(0);
                getModel().getWhereClause().append(" INSERT INTO ");
                //table name
                getModel().getWhereClause().append(getModel().getAnnotationModel().getTableName());
                //table column
                getModel().getWhereClause().append(" (" + getColumnMapping(getModel().getAnnotationModel()) + ") ");
                //values
                getModel().getWhereClause().append("VALUES ");
                getModel().getWhereClause().append("(" + getValuesMapping(getModel().getAnnotationModel(), t) + ")");
                sqls.add(getModel().getWhereClause().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }



    @Override
    public long insert() {
        int responded = 0;
        //Use Transaction
        getModel().getDatabase().beginTransaction();
        for (int i = 0; i < sqls.size(); i++) {
            getModel().getDatabase().execSQL(sqls.get(i), this.values.get(i).toArray(new Object[this.values.get(i).size()]));
            responded++;
        }
        //commit data
        getModel().getDatabase().setTransactionSuccessful();
        getModel().getDatabase().endTransaction();
        return responded;
    }

    /**
     * 按照注解拼接映射关系
     *
     * @param annotationModel
     * @return
     */
    private StringBuilder getColumnMapping(AnnotationModel annotationModel) {
        temp.setLength(0);
        //c1,c2,c3
        for (AnnotationModel.ValueModel valueModel : annotationModel.getValueModels()) {
            temp.append(valueModel.getValue() + ",");
        }
        temp.setLength(temp.length() == 0 ? 0 : temp.length() - 1);
        return temp;
    }

    private StringBuilder getValuesMapping(AnnotationModel annotationModel, T t) throws IllegalAccessException {
        temp.setLength(0);
        //v1,v2,v3
        for (AnnotationModel.ValueModel valueModel : annotationModel.getValueModels()) {
            temp.append("?,");
        }
        temp.setLength(temp.length() == 0 ? 0 : temp.length() - 1);
        setValues(annotationModel, t);
        return temp;
    }


    private void setValues(AnnotationModel annotationModel, T t) throws IllegalAccessException {
        ArrayList<Object> values = new ArrayList<>();
        for (AnnotationModel.ValueModel valueModel : annotationModel.getValueModels()) {
            valueModel.getField().setAccessible(true);
            Object value = valueModel.getField().get(t);
            if (value instanceof String) {
                values.add(String.valueOf(value));
            } else {
                values.add(value);
            }
        }
        this.values.add(values);
    }
}

package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMCreate<C, T> extends AORMCreate<C, T> {
    private List<String> sqls;
    private StringBuilder temp = new StringBuilder();


    public ORMCreate(DBModel model) {
        super(model);
        sqls = new ArrayList<>();
    }

    @Override
    public AORMCreate<C, T> one(T insert) {
        return mults(Arrays.asList(insert));
    }

    @Override
    public AORMCreate<C, T> mults(List<T> inserts) {
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
        int responded = -1;
        //Use Transaction
        getModel().getDatabase().beginTransaction();
        for (String sql : sqls) {
             getModel().getDatabase().execSQL(sql);
            responded++;
        }
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
        temp.setLength(temp.length() - 1);
        return temp;
    }

    private StringBuilder getValuesMapping(AnnotationModel annotationModel, T t) throws IllegalAccessException {
        temp.setLength(0);
        //v1,v2,v3
        for (AnnotationModel.ValueModel valueModel : annotationModel.getValueModels()) {
            Object value = valueModel.getField().get(t);
            if (value instanceof String) {
                temp.append("'" + value + "',");
            } else {
                temp.append(value + ",");
            }
        }
        temp.setLength(temp.length() - 1);
        return temp;
    }

}

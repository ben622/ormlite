package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMUpdate< T> extends AORMUpdate<ORMUpdate<T>, T> {
    public ORMUpdate(DBModel model) {
        super(model);
    }

    @Override
    public long update(T update) {
        return updateMults(Arrays.asList(update));
    }

    @Override
    public long updateMults(List<T> updateMults) {
        int responded = 0;
        try {
            getModel().getDatabase().beginTransaction();
            for (int i = 0; i < updateMults.size(); i++) {
                T update = updateMults.get(i);
                getModel().setContentValues(update);
                responded += getModel().getDatabase().update(getModel().getAnnotationModel().getTableName(), getModel().getContentValues(), getModel().getWhereClause().toString(), getModel().getWhereArgs().toArray(new String[getModel().getWhereArgs().size()]));
            }
            getModel().getDatabase().setTransactionSuccessful();
            getModel().getDatabase().endTransaction();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return responded;
    }
}

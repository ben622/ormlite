package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModelFactory;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMLiteOperator {
    public static < T> ORMCreate<T> createInsert(Class<T> t) {
        return new ORMCreate<T>(DBModelFactory.getDBModelByClass(t));
    }

    public static <T > ORMQuery<T> createQuery(Class<T> t) {
        return new ORMQuery<T>(DBModelFactory.getDBModelByClass(t));
    }

    public static <T> ORMUpdate<T> createUpdate(Class<T> t) {
        return new ORMUpdate<T>(DBModelFactory.getDBModelByClass(t));
    }

    public static <T> ORMDelete<T> createDelete(Class<T> t) {
        
        return new ORMDelete<T>(DBModelFactory.getDBModelByClass(t));
    }


}

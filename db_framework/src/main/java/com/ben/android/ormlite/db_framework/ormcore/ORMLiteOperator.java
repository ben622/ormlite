package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModelFactory;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMLiteOperator {
    public static <C extends AORMCreate<ORMCreate<ORMCreate, T>, T>, T> AORMCreate<C, T> createInsert(Class<T> t) {
        return new ORMCreate<>(DBModelFactory.getDBModelByClass(t));
    }

    public static <C extends AORMQuery<ORMQuery<ORMQuery, T>, T>, T> AORMQuery<C, T> createQuery(Class<T> t) {
        return new ORMQuery<C, T>(DBModelFactory.getDBModelByClass(t));
    }

    public static <C extends AORMUpdate<ORMUpdate<ORMUpdate, T>, T>, T> AORMUpdate<C, T> createUpdate(Class<T> t) {
        return new ORMUpdate<C, T>(DBModelFactory.getDBModelByClass(t));
    }

    public static <C extends AORMDelete<ORMDelete<ORMDelete, T>, T>, T> AORMDelete<C, T> createDelete(Class<T> t) {
        return new ORMDelete<C, T>(DBModelFactory.getDBModelByClass(t));
    }

}

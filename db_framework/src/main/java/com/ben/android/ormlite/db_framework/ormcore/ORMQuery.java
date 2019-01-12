package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMQuery<T> extends AORMQuery<ORMQuery<T>,T> {

    public ORMQuery(DBModel model) {
        super(model);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findLast() {
        return null;
    }

    @Override
    public T findFirst() {
        return null;
    }
}

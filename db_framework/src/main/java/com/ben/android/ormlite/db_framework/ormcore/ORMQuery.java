package com.ben.android.ormlite.db_framework.ormcore;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMQuery<C,T> extends AORMQuery<C,T> {

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

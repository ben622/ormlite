package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMCreate<C,T> extends AORMCreate<C,T> {

    public ORMCreate(DBModel model) {
        super(model);
    }

    @Override
   public AORMCreate<C, T> one(T insert) {
        return null;
    }

    @Override
    public AORMCreate<C, T> mults(List<T> inserts) {
        return null;
    }


    @Override
    public long insert() {
        return 0;
    }
}

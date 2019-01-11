package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.ormcore.operator.IDBCreateOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public abstract class AORMCreate<C,T> implements IDBCreateOperator<T>{
    private DBModel model;

    public DBModel getModel() {
        return model;
    }

    public AORMCreate(DBModel model) {
        this.model = model;

    }

    public abstract AORMCreate<C,T> one(T insert);

    public abstract AORMCreate<C,T> mults(List<T> inserts);
}

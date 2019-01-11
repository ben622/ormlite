package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.ormcore.operator.IDBClauseOperator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public abstract class AORMClause<C,T > implements IDBClauseOperator<C>{
    private DBModel model;

    public AORMClause(DBModel model) {
        this.model = model;
    }

    public DBModel getModel() {
        return model;
    }

    @Override
    public C between(String fieldName, int from, int to) {

        return null;
    }

    @Override
    public C between(String fieldName, double from, double to) {
        return null;
    }

    @Override
    public C between(String fieldName, long from, long to) {
        return null;
    }

    @Override
    public C equalTo(String fieldName, String value) {

        return (C) this;
    }

    @Override
    public C equalTo(String fieldName, int value) {
        return equalTo(fieldName,String.valueOf(value));
    }

    @Override
    public C equalTo(String fieldName, long value) {
        return equalTo(fieldName,String.valueOf(value));
    }

    @Override
    public C equalTo(String fieldName, double value) {
        return equalTo(fieldName,String.valueOf(value));
    }

    @Override
    public C in(String fieldName, String... value) {
        return null;
    }

    @Override
    public C gt(String fieldName, int value) {
        return null;
    }

    @Override
    public C lt(String fieldName, int value) {
        return null;
    }
}

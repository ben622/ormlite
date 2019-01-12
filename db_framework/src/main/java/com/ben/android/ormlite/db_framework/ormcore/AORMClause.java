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
    public C eq(String fieldName, String value) {
        return _equalTo(fieldName,value);
    }

    @Override
    public C eq(String fieldName, int value) {
        return _equalTo(fieldName,value);
    }

    @Override
    public C eq(String fieldName, long value) {
        return _equalTo(fieldName,value);
    }

    @Override
    public C eq(String fieldName, double value) {
        return _equalTo(fieldName,value);
    }

    @Override
    public C eq(String fieldName, float value) {
        return _equalTo(fieldName,value);
    }

    @Override
    public C in(String fieldName, String... value) {
        return null;
    }

    @Override
    public C gt(String fieldName, int value) {
        return _gt(fieldName, value);
    }


    @Override
    public C gt(String fieldName, long value) {
        return _gt(fieldName, value);
    }

    @Override
    public C gt(String fieldName, double value) {
        return _gt(fieldName, value);
    }

    @Override
    public C gt(String fieldName, float value) {
        return _gt(fieldName, value);
    }

    @Override
    public C lt(String fieldName, int value) {
        return _lt(fieldName,value);
    }

    @Override
    public C lt(String fieldName, long value) {
        return _lt(fieldName,value);
    }

    @Override
    public C lt(String fieldName, double value) {
        return _lt(fieldName,value);
    }

    @Override
    public C lt(String fieldName, float value) {
        return _lt(fieldName,value);
    }


    @Override
    public C ge(String fieldName, int value) {
        return _ge(fieldName,value);
    }

    @Override
    public C ge(String fieldName, long value) {
        return _ge(fieldName,value);
    }

    @Override
    public C ge(String fieldName, double value) {
        return _ge(fieldName,value);
    }

    @Override
    public C ge(String fieldName, float value) {
        return _ge(fieldName,value);
    }

    @Override
    public C le(String fieldName, int value) {
        return _le(fieldName,value);
    }

    @Override
    public C le(String fieldName, long value) {
        return _le(fieldName,value);
    }

    @Override
    public C le(String fieldName, double value) {
        return _le(fieldName,value);
    }

    @Override
    public C le(String fieldName, float value) {
        return _le(fieldName,value);
    }


    @Override
    public C nq(String fieldName, int value) {
        return _nq(fieldName,value);
    }

    @Override
    public C nq(String fieldName, long value) {
        return _nq(fieldName,value);
    }

    @Override
    public C nq(String fieldName, double value) {
        return _nq(fieldName,value);
    }

    @Override
    public C nq(String fieldName, float value) {
        return _nq(fieldName,value);
    }
    private C _equalTo(String fieldName, Object value) {
        getModel().getWhereClause().append(" and " + fieldName + "=? ");
        getModel().getWhereArgs().add(String.valueOf(value));
        return (C) this;
    }
    private C _nq(String fieldName, Object value) {
        getModel().getWhereClause().append(" and " + fieldName + "<>? ");
        getModel().getWhereArgs().add(String.valueOf(value));
        return (C) this;
    }
    private C _gt(String fieldName, Object value) {
        getModel().getWhereClause().append(" and " + fieldName + ">? ");
        getModel().getWhereArgs().add(String.valueOf(value));
        return (C) this;
    }
    private C _lt(String fieldName, Object value) {
        getModel().getWhereClause().append(" and " + fieldName + "<? ");
        getModel().getWhereArgs().add(String.valueOf(value));
        return (C) this;
    }
    private C _ge(String fieldName, Object value) {
        getModel().getWhereClause().append(" and " + fieldName + ">=? ");
        getModel().getWhereArgs().add(String.valueOf(value));
        return (C) this;
    }
    private C _le(String fieldName, Object value) {
        getModel().getWhereClause().append(" and " + fieldName + "<=? ");
        getModel().getWhereArgs().add(String.valueOf(value));
        return (C) this;
    }
}

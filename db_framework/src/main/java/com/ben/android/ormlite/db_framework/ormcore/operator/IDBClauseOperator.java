package com.ben.android.ormlite.db_framework.ormcore.operator;

import com.ben.android.ormlite.db_framework.ormcore.AORMClause;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc 操作符
 */
public interface IDBClauseOperator<C> {
    C between(String fieldName, int from, int to);

    C between(String fieldName, double from, double to);

    C between(String fieldName, long from, long to);



    C gt(String fieldName, int value);
    C gt(String fieldName, long value);
    C gt(String fieldName, double value);
    C gt(String fieldName, float value);

    C lt(String fieldName, int value);
    C lt(String fieldName, long value);
    C lt(String fieldName, double value);
    C lt(String fieldName, float value);

    C ge(String fieldName, int value);
    C ge(String fieldName, long value);
    C ge(String fieldName, double value);
    C ge(String fieldName, float value);

    C le(String fieldName, int value);
    C le(String fieldName, long value);
    C le(String fieldName, double value);
    C le(String fieldName, float value);


    C nq(String fieldName, int value);
    C nq(String fieldName, long value);
    C nq(String fieldName, double value);
    C nq(String fieldName, float value);

    C eq(String fieldName, String value);
    C eq(String fieldName, int value);
    C eq(String fieldName, long value);
    C eq(String fieldName, double value);
    C eq(String fieldName, float value);

    C in(String fieldName, String... value);

}

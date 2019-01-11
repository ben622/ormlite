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

    C equalTo(String fieldName, String value);

    C equalTo(String fieldName, int value);

    C equalTo(String fieldName, long value);

    C equalTo(String fieldName, double value);

    C gt(String fieldName, int value);

    C lt(String fieldName, int value);

    C in(String fieldName, String... value);

}

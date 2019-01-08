package com.ben.android.ormlite.db_framework.dbcore.operator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc 操作符
 */
public interface IDBModelOperator<T> {
    IDBModelOperator<T> between(String fieldName, int from, int to);

    IDBModelOperator<T> between(String fieldName, double from, double to);

    IDBModelOperator<T> between(String fieldName, long from, long to);

    IDBModelOperator<T> equalTo(String fieldName, String value);

    IDBModelOperator<T> equalTo(String fieldName, int value);

    IDBModelOperator<T> equalTo(String fieldName, long value);

    IDBModelOperator<T> equalTo(String fieldName, double value);

    IDBModelOperator<T> in(String fieldName, String... value);

}

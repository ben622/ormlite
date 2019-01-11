package com.ben.android.ormlite.db_framework.ormcore.operator;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @dewsc 查询操作符
 */
public interface IDBRetrieveOperator<T>{
    List<T> findAll();
    T findLast();
    T findFirst();
}

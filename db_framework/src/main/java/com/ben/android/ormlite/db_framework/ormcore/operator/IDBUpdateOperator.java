package com.ben.android.ormlite.db_framework.ormcore.operator;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc 修改操作符
 */
public interface IDBUpdateOperator<T> {
    long update(T update);

    long updateMults(List<T> updateMults);
}

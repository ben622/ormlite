package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.IORMLite;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc ORM实现
 */
public interface ORMLite<T>{
    long insert(T insert);

    int delete(T delete);

    int update(T update,T where);

    List<T> query(T t);

}

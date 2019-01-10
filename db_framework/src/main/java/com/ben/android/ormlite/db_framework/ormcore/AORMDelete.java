package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.ormcore.operator.IDBDeleteOperator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public abstract class AORMDelete<C,T> extends AORMClause<C,T> implements IDBDeleteOperator<T> {
}

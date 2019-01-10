package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.ormcore.operator.IDBRetrieveOperator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public abstract class AORMQuery<C ,T > extends AORMClause<C,T> implements IDBRetrieveOperator<T> {

}

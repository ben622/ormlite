package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.ormcore.operator.IDBRetrieveOperator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public abstract class AORMQuery<C extends AORMQuery<C,T>,T > extends AORMClause<C,T> implements IDBRetrieveOperator<T> {

    public AORMQuery(DBModel model) {
        super(model);
    }

    public abstract AORMQuery<C, T> orderBy(String column, String o);
    public abstract AORMQuery<C, T> limit(int start, int end);
}

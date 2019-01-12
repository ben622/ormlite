package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.ormcore.operator.IDBUpdateOperator;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public abstract class AORMUpdate<C extends AORMUpdate,T> extends AORMClause<C,T> implements IDBUpdateOperator<T> {
    public AORMUpdate(DBModel model) {
        super(model);
    }


}

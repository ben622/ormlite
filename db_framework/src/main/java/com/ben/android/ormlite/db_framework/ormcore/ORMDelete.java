package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMDelete<C,T> extends AORMDelete<C,T> {
    public ORMDelete(DBModel model) {
        super(model);
    }

    @Override
    public int delete() {
        return 0;
    }
}

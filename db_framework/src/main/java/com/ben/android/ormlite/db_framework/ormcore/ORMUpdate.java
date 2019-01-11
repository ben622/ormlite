package com.ben.android.ormlite.db_framework.ormcore;

import com.ben.android.ormlite.db_framework.DBModel;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class ORMUpdate<C,T>  extends AORMUpdate<C,T> {
    public ORMUpdate(DBModel model) {
        super(model);
    }

    @Override
    public long update() {
        return 0;
    }
}

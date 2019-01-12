package com.ben.android.ormlite.db_framework;

import android.content.Context;

import com.ben.android.ormlite.db_framework.ormcore.AORMCreate;
import com.ben.android.ormlite.db_framework.ormcore.AORMDelete;
import com.ben.android.ormlite.db_framework.ormcore.AORMQuery;
import com.ben.android.ormlite.db_framework.ormcore.AORMUpdate;
import com.ben.android.ormlite.db_framework.ormcore.ORMCreate;
import com.ben.android.ormlite.db_framework.ormcore.ORMDelete;
import com.ben.android.ormlite.db_framework.ormcore.ORMLiteOperator;
import com.ben.android.ormlite.db_framework.ormcore.ORMQuery;
import com.ben.android.ormlite.db_framework.ormcore.ORMUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public final class ORMLite extends BaseLite {
    public static void init(Context context) {
        init(context, null);
    }

    public static void init(Context context, ORMLiteConfiguration configuration) {
        BaseLite.init(context, configuration);
    }

    public static ORMLite newLite() {
        return new ORMLite();
    }

    public static <T> ORMCreate<T> insert(Class<T> t) {
        return ORMLiteOperator.createInsert(t);
    }

    public <T> ORMQuery<T> query(Class<T> t) {
        return ORMLiteOperator.createQuery(t);
    }

    public <T> ORMUpdate<T> update(Class<T> t) {
        return ORMLiteOperator.createUpdate(t);
    }

    public <T> ORMDelete<T> delete(Class<T> t) {
        return ORMLiteOperator.createDelete(t);
    }


}

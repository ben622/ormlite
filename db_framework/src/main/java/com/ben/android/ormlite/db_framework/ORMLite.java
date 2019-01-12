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
    public  static  <C extends AORMCreate<ORMCreate<ORMCreate,T>,T>,T> AORMCreate<C, T> insert(Class<T> t) {
        return ORMLiteOperator.createInsert(t);
    }
    public <C extends AORMQuery<ORMQuery<ORMQuery, T>, T>, T> AORMQuery<C, T> query(Class<T> t) {
        return ORMLiteOperator.createQuery(t);
    }

    public <C extends AORMUpdate<ORMUpdate<ORMUpdate, T>, T>, T> AORMUpdate<C, T> update(Class<T> t) {
        return ORMLiteOperator.createUpdate(t);
    }
    public  <C extends AORMDelete<ORMDelete<ORMDelete, T>, T>, T> AORMDelete<C, T> delete(Class<T> t) {
        return ORMLiteOperator.createDelete(t);
    }



}

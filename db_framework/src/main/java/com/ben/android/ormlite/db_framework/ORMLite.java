package com.ben.android.ormlite.db_framework;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.dbcore.operator.IDBModelOperator;
import com.ben.android.ormlite.db_framework.ormcore.AORMLiteModel;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public final class ORMLite<T> extends BaseLite  {

    public static synchronized void init(Context context) {
        init(context, null);
    }

    public static synchronized void init(Context context, ORMLiteConfiguration configuration) {
        BaseLite.init(context, configuration);
    }

    public static ORMLite getDefaultInstance(Class<?> cls) {
        if (mOrmLite == null) {
            synchronized (ORMLite.class) {
                if (mOrmLite == null) {
                    mOrmLite = new ORMLite();
                }
            }
        }
        return mOrmLite;
    }



    //ORMLite.getDefaultInstance(User.class).insertOperator().entity().insert(User);
    //ORMLite.getDefaultInstance(User.class).queryOperator().equaseTo("userId",15910910352).query();
    //ORMLite.getDefaultInstance(User.class).updateOperator().equaseTo("userId",15910910352).update();
    //ORMLite.getDefaultInstance(User.class).deleteOperator().equaseTo("userId",15910910352).delete();
    //ORMLite.getDefaultInstance(User.class).sql("select * from user").execute();


}

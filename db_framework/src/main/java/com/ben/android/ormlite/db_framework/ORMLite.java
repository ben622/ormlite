package com.ben.android.ormlite.db_framework;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.BaseExpandableListAdapter;

import com.ben.android.ormlite.db_framework.annotation.AnnotationManager;
import com.ben.android.ormlite.db_framework.sqlcore.SQLite;


import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public final class ORMLite<T> extends BaseLite {

    public static synchronized void init(Context context) {
        init(context, null);
    }

    public static synchronized void init(Context context, ORMLiteConfiguration configuration) {
        BaseLite.init(context, configuration);
    }

    public static ORMLite getDefaultInstance() {
        if (mOrmLite == null) {
            synchronized (ORMLite.class) {
                if (mOrmLite == null) {
                    mOrmLite = new ORMLite();
                }
            }
        }
        return mOrmLite;
    }

    public void insert() {
        SQLiteDatabase database = null;
        ContentValues values = new ContentValues();
        values.put("userId", "admin");
        database.insert("tb_user", null, values);

        database.delete("tab_user", " 1=1 and userId=? ", new String[]{"1"});

        values = new ContentValues();
        values.put("userName", "administroat");
        database.update("tab_user", values, " 1=1 and userId = ? ", new String[]{"2"});


    }

    public int update() {


        return 0;
    }


}

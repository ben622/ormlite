package com.ben.android.ormlite.db_framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.annotation.AnnotationManager;
import com.ben.android.ormlite.db_framework.dbcore.DBCoreManager;
import com.ben.android.ormlite.db_framework.dbcore.SQLiteDatabaseFactory;
import com.ben.android.ormlite.db_framework.dbcore.synchronize.Condition;

import java.lang.ref.WeakReference;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
abstract class BaseLite {
    private static final String NATIVE_LIBRARY = "ormlite";
    private static WeakReference<Context> mApplicationContext;
    private static AnnotationManager annotationManager;
    private static ORMLiteConfiguration configuration;
    private static SQLiteDatabase database;

    protected static String TAG = DBConstants.DB_TAG;
    /**
     * ORMLite初始化条件变量，用于处理在多线程环境下操作流程完整性,对数据的操作需要对此变量做检查
     */
    protected static Condition.InitCondition condition = new Condition.InitCondition();

    public static void init(Context context) {
        init(context, null);
    }

    public static void init(Context context, ORMLiteConfiguration configuration) {
        synchronized (condition) {
            try {
                condition.state = Condition.InitState.START_INIT;

                if (context == null) {
                    throw new IllegalArgumentException("Non-null context required.");
                }
                //load library
                System.loadLibrary(NATIVE_LIBRARY);
                BaseLite.mApplicationContext = new WeakReference<>(context);
                //确保存在一个configuration
                BaseLite.configuration = configuration == null ? ORMLiteConfiguration.createDefaultORMLiteConfiguration() : configuration;
                //初始化注解
                annotationManager = AnnotationManager.initialize(BaseLite.mApplicationContext.get());
                //open database
                database = SQLiteDatabaseFactory.openOrCreateDatabase(BaseLite.configuration);
                //update database
                DBCoreManager.initialize(annotationManager);

            } catch (Exception e) {
                e.printStackTrace();
                condition.state = Condition.InitState.INIT_ERROR;
            }
        }
    }

    public static Context getApplicationContext() {
        if (mApplicationContext != null) {
            return mApplicationContext.get();
        }
        return null;
    }

    public static ORMLiteConfiguration getConfiguration() {
        return configuration;
    }

    public static AnnotationManager getAnnotationManager() {
        return annotationManager;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }
}

package com.ben.android.ormlite.db_framework.dbcore;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/11
 */
public class DBCoreFactory {
    public static <T extends ADBHelper>  T createDBHelper(Class<T> t){
        try {
            return t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

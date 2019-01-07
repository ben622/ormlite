package com.ben.android.ormlite.db_framework.security;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public class SecurityFactory {
    public static <T extends AORMSecurity> T getSecurity(Class<T> t){
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

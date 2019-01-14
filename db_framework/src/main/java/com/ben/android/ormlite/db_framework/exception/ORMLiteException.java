package com.ben.android.ormlite.db_framework.exception;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/14
 */
public  class ORMLiteException extends RuntimeException {
    public ORMLiteException(String message) {
        super(message);
    }

    public ORMLiteException(String message, Throwable cause) {
        super(message, cause);
    }
}

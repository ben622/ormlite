package com.ben.android.ormlite.db_framework.dbcore;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc 数据库操作，升级表、删除表、创建表
 *
 * tb_ormlite_tabinfo
 * tb_id,tb_name,tb_update_time,tb
 *
 *
 *
 *
 *
 */
public interface IDBHelper<T extends AnnotationModel> {
    void execSQL(SQLiteDatabase database,T t);
}

package com.ben.android.ormlite.db_framework.dbcore.log;

import com.ben.android.ormlite.db_framework.annotation.Column;
import com.ben.android.ormlite.db_framework.annotation.Table;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/14
 */
@Table("orm_db_version")
public class DBVersion {
    @Column("tb_table_name")
    private String tableName;

}

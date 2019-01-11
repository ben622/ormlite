package com.ben.android.ormlite.db_framework.dbcore;

import java.util.HashMap;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/11
 * @desc 支持的数据类型
 */
public class DBPrimTypes {
    public static final HashMap<String, String> TYPES_MAPPINGS = new HashMap<>();
    static {
        TYPES_MAPPINGS.put("java.lang.Integer", "INTEGER");
        TYPES_MAPPINGS.put("java.lang.String", "TEXT");
        TYPES_MAPPINGS.put("java.lang.Double", "REAL");
        TYPES_MAPPINGS.put("java.lang.Float", "REAL");
        TYPES_MAPPINGS.put("java.lang.Boolean", "BOOLEAN");
    }
}

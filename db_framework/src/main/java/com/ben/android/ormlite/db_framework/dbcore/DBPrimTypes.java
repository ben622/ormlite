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
        TYPES_MAPPINGS.put("java.lang.Long", "BOOLEAN");
        TYPES_MAPPINGS.put("java.lang.Boolean", "BOOLEAN");
        TYPES_MAPPINGS.put("java.lang.Byte", "BLOB");
        TYPES_MAPPINGS.put("int", "INTEGER");
        TYPES_MAPPINGS.put("double", "REAL");
        TYPES_MAPPINGS.put("float", "REAL");
        TYPES_MAPPINGS.put("long", "REAL");
        TYPES_MAPPINGS.put("boolean", "BOOLEAN");
        TYPES_MAPPINGS.put("byte", "BLOB");
    }
}

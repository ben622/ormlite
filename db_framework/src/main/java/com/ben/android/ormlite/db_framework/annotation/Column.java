package com.ben.android.ormlite.db_framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    /**
     * 在数据库中的字段名称
     * @return
     */
    String value() default "";

    /**
     * 是否主键
     * @return
     */
    boolean primaryKey() default false;

    /**
     * 是否外键
     * @return
     */
    boolean foreignKey() default false;



}

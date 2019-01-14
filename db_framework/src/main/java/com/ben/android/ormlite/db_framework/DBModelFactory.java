package com.ben.android.ormlite.db_framework;

import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;
import com.ben.android.ormlite.db_framework.dbcore.synchronize.Condition;
import com.ben.android.ormlite.db_framework.exception.ORMLiteException;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/10
 */
public class DBModelFactory {
    public static <T> DBModel getDBModelByClass(Class<T> cls) {
        if (BaseLite.getApplicationContext() == null || BaseLite.condition.state == Condition.InitState.UNINIT) {
            throw new ORMLiteException("ORMLite is not initialized, please try again with ORMLite.init()！");
        }
        AnnotationModel annotationModel = BaseLite.getAnnotationManager().getAnnotationModelByClass(cls);
        if (annotationModel == null) {
            throw new IllegalArgumentException("not find @" + cls.getName());
        }
        DBModel model = new DBModel();
        model.setConfiguration(BaseLite.getConfiguration());
        model.setAnnotationModel(annotationModel);
        model.setDatabase(BaseLite.getDatabase());
        return model;
    }
}

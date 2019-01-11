package com.ben.android.ormlite.db_framework.dbcore;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.DBModelFactory;
import com.ben.android.ormlite.db_framework.annotation.AnnotationManager;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;
import com.ben.android.ormlite.db_framework.dbcore.upgrade.CreateTableHelper;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/11
 * @desc 提供数据库管理
 */
public class DBCoreManager {
    private static DBCoreManager dbCoreManager;
    private AnnotationManager annotationManager;
    private ADBHelper createHelper;

    public DBCoreManager(AnnotationManager annotationManager) {
        this.annotationManager = annotationManager;
        createHelper = DBCoreFactory.createDBHelper(CreateTableHelper.class);
        initCreateTable();

    }

    private void initCreateTable() {
        List<AnnotationModel> annotationModelList = annotationManager.getAnnotationModelList();
        for (AnnotationModel annotationModel : annotationModelList) {
            DBModel dbModel = DBModelFactory.getDBModelByClass(annotationModel.getCls());
            createHelper.execSQL(dbModel,null);
        }

    }

    public static DBCoreManager initialize(AnnotationManager annotationManager) {
        if (dbCoreManager == null) {
            synchronized (DBCoreManager.class) {
                if (dbCoreManager == null) {
                    dbCoreManager = new DBCoreManager(annotationManager);
                }
            }
        }
        return dbCoreManager;
    }

}

package com.ben.android.ormlite.db_framework.dbcore.upgrade;

import android.database.sqlite.SQLiteDatabase;

import com.ben.android.ormlite.db_framework.DBModel;
import com.ben.android.ormlite.db_framework.annotation.AnnotationModel;
import com.ben.android.ormlite.db_framework.dbcore.DBPrimTypes;
import com.ben.android.ormlite.db_framework.dbcore.IDBHelper;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc 创建数据库表
 */
class CreateTableHelper<T> implements IDBHelper<T> {

    StringBuilder temp = new StringBuilder();

    @Override
    public void execSQL(DBModel model, T t) {
        model.getWhereClause().setLength(0);
        model.getWhereClause().append("CREATE TABLE ");
        //TABLE NAME
        model.getWhereClause().append(model.getAnnotationModel().getTableName());
        model.getWhereClause().append(" ( ");

        model.getWhereClause().append(parseColumnAndProperty(model.getAnnotationModel()));


        model.getWhereClause().append(" ) ");

        model.getDatabase().execSQL(model.getWhereClause().toString());
    }

    private StringBuilder parseColumnAndProperty(AnnotationModel annotationModel) {
        temp.setLength(0);
        for (int i = 0; i < annotationModel.getValueModels().size(); i++) {
            AnnotationModel.ValueModel valueModel = annotationModel.getValueModels().get(i);
            if (valueModel.isPrimaryKey()) {
                Class<?> type = valueModel.getField().getType();
                temp.append(valueModel.getValue() + " ");
                temp.append(DBPrimTypes.TYPES_MAPPINGS.get(type.getName()));
                temp.append(valueModel.isPrimaryKey() ? " PRIMARY KEY  NOT NULL, " : ", ");
            }

        }
        temp.setLength(temp.length() - 1);
        return temp;
    }
}

package com.ben.android.ormlite.db_framework.annotation;

import android.content.Context;
import android.text.TextUtils;

import com.ben.android.ormlite.db_framework.utils.ClassUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 * @desc 注解解析
 */
class DBAnnotation implements IParseAnnotation, IScannerAnnotation {
    @Override
    public List<AnnotationModel> parseALl(List<Class<?>> classs) {
        List<AnnotationModel> annotationModelList = new ArrayList<>();
        for (int i = 0; classs != null && i < classs.size(); i++) {
            AnnotationModel annotationModel = new AnnotationModel();
            Class<?> cls = classs.get(i);
            annotationModel.setCalss(cls);
            Table tab = cls.getAnnotation(Table.class);
            annotationModel.setTable(tab);
            annotationModel.setTableName(TextUtils.isEmpty(tab.value()) ? cls.getSimpleName() : tab.value());
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                annotationModel.getValueModels().add(parseValueModel(field));
            }
            annotationModelList.add(annotationModel);
        }
        return annotationModelList;
    }

    @Override
    public AnnotationModel parseOnly(Class<?> cls) {
        return null;
    }



    @Override
    public List<Class<?>> scanner(Context context) {
        //只加载含有@Table注解的class
        List<Class<?>> classList = new ArrayList<>();
        try {
            List<String> classNameByPackageName = ClassUtil.getFileNameByPackageName(context, context.getPackageName());
            for (String className : classNameByPackageName) {
                Class<?> classs = Class.forName(className);
                Table tableAnnotation = classs.getAnnotation(Table.class);
                if (tableAnnotation == null) {
                    continue;
                }
                classList.add(classs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }

    private AnnotationModel.ValueModel parseValueModel(Field field) {
        AnnotationModel.ValueModel valueModel = new AnnotationModel.ValueModel();
        Column annotation = field.getAnnotation(Column.class);
        valueModel.setValue(TextUtils.isEmpty(annotation.value()) ? field.getName() : annotation.value());
        valueModel.setPrimaryKey(annotation.primaryKey());
        valueModel.setForeignKey(annotation.foreignKey());
        valueModel.setForeignTableName(annotation.foreignTableName());
        valueModel.setForeignTableColumnName(annotation.foreignTableColumnName());

        valueModel.setColumn(annotation);
        valueModel.setField(field);
        return valueModel;
    }


}

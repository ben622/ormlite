package com.ben.android.ormlite.db_framework.annotation;

import android.content.Context;

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
            annotationModel.setTable(cls.getAnnotation(Table.class));
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                annotationModel.setColumn(field.getAnnotation(Column.class));
                annotationModel.setField(field);
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


}

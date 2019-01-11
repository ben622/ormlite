package com.ben.android.ormlite.db_framework.annotation;

import android.content.Context;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public class AnnotationManager {
    private static AnnotationManager annotationManager;
    private Context context;
    private IDBAnnotation dbAnnotation;
    private List<Class<?>> classList;
    private List<AnnotationModel> annotationModelList;

    public AnnotationManager(Context context) {
        this.context = context;
        initAnnotation();
    }

    private void initAnnotation() {
        dbAnnotation = new DBAnnotation();
        scaner();
        parse();
    }

    public static AnnotationManager initialize(Context context) {
        if (annotationManager == null) {
            synchronized (AnnotationManager.class) {
                if (annotationManager == null) {
                    annotationManager = new AnnotationManager(context);
                }
            }
        }
        return annotationManager;
    }


    public void scaner() {
        classList = ((IScannerAnnotation) dbAnnotation).scanner(context);
    }

    public void parse() {
        annotationModelList = ((IParseAnnotation) dbAnnotation).parseALl(classList);
    }

    public List<Class<?>> getClassList() {
        return classList;
    }

    public List<AnnotationModel> getAnnotationModelList() {
        return annotationModelList;
    }
    public <T> AnnotationModel getAnnotationModelByClass(Class<T> cls){
        for (AnnotationModel annotationModel : annotationModelList) {
            if (annotationModel.getCls().equals(cls)) {
                return annotationModel;
            }
        }
        return null;
    }
}

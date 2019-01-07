package com.ben.android.ormlite.db_framework.annotation;

import java.util.List;

interface IParseAnnotation extends IDBAnnotation {
    List<AnnotationModel> parseALl(List<Class<?>> classs);

    AnnotationModel parseOnly(Class<?> cls);
}

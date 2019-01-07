package com.ben.android.ormlite.db_framework.annotation;

import android.content.Context;

import java.util.List;

interface IScannerAnnotation extends IDBAnnotation {
    List<Class<?>> scanner(Context context);
}

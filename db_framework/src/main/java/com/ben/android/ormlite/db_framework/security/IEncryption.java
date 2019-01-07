package com.ben.android.ormlite.db_framework.security;

import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
interface IEncryption {
    SecurityResponse _encryption(ORMLiteConfiguration configuration,String source);
}

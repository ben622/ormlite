package com.ben.android.ormlite.db_framework.security;

import com.ben.android.ormlite.db_framework.ORMLite;
import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 * @desc ORMLite默认安全处理
 */
public class ORMSecurity extends AORMSecurity {
    @Override
    SecurityResponse decryption(ORMLiteConfiguration configuration, String source) {
        return nativeSecurity.nativeDecryption(configuration,source);
    }

    @Override
    SecurityResponse encryption(ORMLiteConfiguration configuration, String source) {
        return nativeSecurity.nativeEncryption(configuration, source);
    }
}

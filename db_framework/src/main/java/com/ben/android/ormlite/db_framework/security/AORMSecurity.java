package com.ben.android.ormlite.db_framework.security;

import android.text.TextUtils;

import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 */
public abstract class AORMSecurity implements IDCryption, IEncryption {
    protected NativeSecurity nativeSecurity;

    public AORMSecurity() {
        nativeSecurity = new NativeSecurity();
    }

    /**
     * 验证配置中是否存在Key，如果不存在则使用默认的Key
     * @param configuration
     * @param source
     */
    private void verifySecurityKey(ORMLiteConfiguration configuration, String source) {
        SecurityKeyManager.verifySecurityKey(configuration);
    }

    @Override
    public SecurityResponse _decryption(ORMLiteConfiguration configuration, String source) {
        verifySecurityKey(configuration, source);
        return decryption(configuration, source);
    }

    @Override
    public SecurityResponse _encryption(ORMLiteConfiguration configuration, String source) {
        verifySecurityKey(configuration, source);
        return encryption(configuration, source);
    }


    abstract SecurityResponse decryption(ORMLiteConfiguration configuration, String source);

    abstract SecurityResponse encryption(ORMLiteConfiguration configuration, String source);
}

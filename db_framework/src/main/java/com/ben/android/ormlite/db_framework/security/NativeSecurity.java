package com.ben.android.ormlite.db_framework.security;

import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 * @desc 使用配置中的key对数据进行加密处理
 */
class NativeSecurity {

    /**
     * 加密处理
     * @param configuration
     * @param source 元数据
     * @return 从native中获取加密结果
     */
    public native SecurityResponse nativeEncryption(ORMLiteConfiguration configuration, String source);

    /**
     * 解密处理
     * @param configuration
     * @param source 元数据
     * @return 从native获取解密结果
     */
    public native SecurityResponse nativeDecryption(ORMLiteConfiguration configuration, String source);
}

package com.ben.android.ormlite.db_framework;

import android.os.Environment;

import com.ben.android.ormlite.db_framework.cache.ICacheStrategy;
import com.ben.android.ormlite.db_framework.security.AORMSecurity;

import java.io.File;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public class ORMLiteConfiguration {
    private Builder mBuilder;

    private ORMLiteConfiguration(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public Builder getBuilder() {
        return mBuilder;
    }

    /**
     * 创建ORMLite默认配置
     *
     * @return
     */
    public static ORMLiteConfiguration createDefaultORMLiteConfiguration() {
        return new Builder()
                .directory(new File(DBConstants.DEFAULT_DB_DIRECTORY))
                .name(DBConstants.DEFAULT_DB_NAME)
                .cache(false)
                .encryption(false)
                .build();
    }

    public static class Builder {
        /**
         * 数据库存放路径
         */
        private File dbDirectory;
        /**
         * 数据库名
         */
        private String dbName;
        /**
         * 加密的key
         */
        private String decryptionKey;
        /**
         * 数据是否加密
         */
        private boolean isEncryption;
        /**
         * 加密解密处理
         */
        private AORMSecurity security;
        /**
         * 是否需要缓存
         */
        private boolean isCache;
        /**
         * 缓存策略
         */
        private ICacheStrategy cacheStrategy;


        public File getDbDirectory() {
            return dbDirectory;
        }

        public Builder directory(File dbDirectory) {
            this.dbDirectory = dbDirectory;
            return this;
        }

        public String getDbName() {
            return dbName;
        }

        public Builder name(String dbName) {
            this.dbName = dbName;
            return this;
        }

        public String getDecryptionKey() {
            return decryptionKey;
        }

        public Builder decryptionKey(String decryptionKey) {
            this.decryptionKey = decryptionKey;
            return this;
        }

        public boolean isEncryption() {
            return isEncryption;
        }

        public Builder encryption(boolean encryption) {
            isEncryption = encryption;
            return this;
        }

        public boolean isCache() {
            return isCache;
        }

        public Builder cache(boolean cache) {
            isCache = cache;
            return this;
        }

        public ICacheStrategy getCacheStrategy() {
            return cacheStrategy;
        }

        public Builder cacheStrategy(ICacheStrategy cacheStrategy) {
            this.cacheStrategy = cacheStrategy;
            return this;
        }

        public AORMSecurity getSecurity() {
            return security;

        }

        public Builder security(AORMSecurity security) {
            this.security = security;
            return this;
        }

        public ORMLiteConfiguration build() {
            return new ORMLiteConfiguration(this);
        }
    }
}

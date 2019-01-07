package com.ben.android.ormlite.db_framework.security;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.ben.android.ormlite.db_framework.DBConstants;
import com.ben.android.ormlite.db_framework.ORMLite;
import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 * @desc 优先使用配置中的Key，如果不存在则使用APP签名SHA1值作为key使用，否则使用数据库表名作为key
 */
class SecurityKeyManager {
    public static void verifySecurityKey(ORMLiteConfiguration configuration) {
        if (configuration != null && TextUtils.isEmpty(configuration.getBuilder().getDecryptionKey())) {
            configuration.getBuilder().decryptionKey(getAppSignaturesSHA1());
        }
    }
    public static String getAppSignaturesSHA1(){
            try {
                PackageInfo info = ORMLite.getApplicationContext().getPackageManager().getPackageInfo(
                        ORMLite.getApplicationContext().getPackageName(), PackageManager.GET_SIGNATURES);
                byte[] cert = info.signatures[0].toByteArray();
                MessageDigest md = MessageDigest.getInstance("SHA1");
                byte[] publicKey = md.digest(cert);
                StringBuffer hexString = new StringBuffer();
                for (int i = 0; i < publicKey.length; i++) {
                    String appendString = Integer.toHexString(0xFF & publicKey[i])
                            .toUpperCase(Locale.US);
                    if (appendString.length() == 1)
                        hexString.append("0");
                    hexString.append(appendString);
                    hexString.append(":");
                }
                String result = hexString.toString();
                return result.substring(0, result.length()-1);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        return DBConstants.DEFAULT_DB_NAME;
    }
}

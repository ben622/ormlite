#include <jni.h>
#include "include/security.h"
#include <android/log.h>
//
// Created by zhangchuan622@gmail.com on 2019/1/5.
//
#define PRINT_TAG "ormlite"
#define RESPONSE_CLASS_PATH  "com/ben/android/ormlite/db_framework/security/SecurityResponse"
#define LOGI(FORMAT, ...) __android_log_print(ANDROID_LOG_VERBOSE,PRINT_TAG,FORMAT,__VA_ARGS__)
#define LOGE(FORMAT, ...) __android_log_print(ANDROID_LOG_ERROR,PRINT_TAG,FORMAT,__VA_ARGS__)
namespace ormlite {
    /**
     * 构造函数
     * @param key 加密解密的key
     */
    Security::Security(const char *key) {
        this->securityKey = const_cast<char *>(key);
    }

    /**
     * 析构函数
     */
    Security::~Security() {

    }

    /**
     * 加密
     * @param body
     * @return
     */
    void* Security::encryption(const char *body) {
        const char *key_str = this->securityKey;

        char *encr = (char *) alloca(sizeof(char) * strlen(body));
        for (int i = 0; i < strlen(body); i++) {
            encr[i] = (body[i] ^ key_str[i % strlen(key_str)]);
        }

        return encr;
    }

    /**
     * 解密
     * @param body
     * @return
     */
    void* Security::decryption(const char *body) {
        const char *key_str = this->securityKey;

        char *dec = (char *) alloca(sizeof(char) * strlen(body));
        for (int i = 0; i < strlen(body); i++) {
            dec[i] = (body[i] ^ key_str[i % strlen(key_str)]);
        }

        return dec;
    }

}



JNIEnv *env;
jobject response = NULL;
/**
 * 封装message
 */
void  loadResponse(jstring orign, jstring res){
    if (response == NULL) {
        LOGE("%s", "response null!");
        return;
    }
    jclass  responseClass = env->GetObjectClass(response);
    jmethodID orignbodyMethodId = env->GetMethodID(responseClass,"setOrignbody","(Ljava/lang/String;)V");
    jmethodID responseMethodId = env->GetMethodID(responseClass,"setResponse","(Ljava/lang/String;)V");

    env->CallVoidMethod(response,orignbodyMethodId, orign);
    env->CallVoidMethod(response,responseMethodId, res);

}
/**
 * 加密处理
 */
extern "C"
JNIEXPORT jobject JNICALL
Java_com_ben_android_ormlite_db_1framework_security_NativeSecurity_nativeEncryption(JNIEnv *env,
                                                                                    jobject instance,
                                                                                    jobject configuration,
                                                                                    jstring source_) {
    const char *source = env->GetStringUTFChars(source_, 0);
    // 获取key
    jclass configurationClass = env->GetObjectClass(configuration);
    jfieldID builderFieldId = env->GetFieldID(configurationClass,"mBuilder","Lcom/ben/android/ormlite/db_framework/ORMLiteConfiguration;");
    jobject builderObject = env->GetObjectField(configuration,builderFieldId);
    jclass  builderClass = env->GetObjectClass(builderObject);
    jmethodID keyMethodId = env->GetMethodID(builderClass, "decryptionKey", "()Ljava/lang/String;");
    jstring javaKey = static_cast<jstring>(env->CallObjectMethod(builderObject, keyMethodId));
    const  char *ckey = env->GetStringUTFChars(javaKey,0);
    //加密
    ormlite::Security *security = new ormlite::Security(ckey);
    char *encr = static_cast<char *>(security->encryption(source));
    //将加密信息装载至response
    loadResponse(source_, env->NewStringUTF(encr));

    //释放资源
    env->ReleaseStringUTFChars(source_, source);
    env->ReleaseStringUTFChars(javaKey, ckey);
    delete (security);
    //将加密结果返回
    return response;
}

/**
 * 解密处理
 */
extern "C"
JNIEXPORT jobject JNICALL
Java_com_ben_android_ormlite_db_1framework_security_NativeSecurity_nativeDecryption(JNIEnv *env,
                                                                                    jobject instance,
                                                                                    jobject configuration,
                                                                                    jstring source_) {
    const char *source = env->GetStringUTFChars(source_, 0);
    // 获取key
    jclass configurationClass = env->GetObjectClass(configuration);
    jfieldID builderFieldId = env->GetFieldID(configurationClass,"mBuilder","Lcom/ben/android/ormlite/db_framework/ORMLiteConfiguration;");
    jobject builderObject = env->GetObjectField(configuration,builderFieldId);
    jclass  builderClass = env->GetObjectClass(builderObject);
    jmethodID keyMethodId = env->GetMethodID(builderClass, "decryptionKey", "()Ljava/lang/String;");
    jstring javaKey = static_cast<jstring>(env->CallObjectMethod(builderObject, keyMethodId));
    const  char *ckey = env->GetStringUTFChars(javaKey,0);

    ormlite::Security *security = new ormlite::Security(ckey);
    //解密
    char *dec = static_cast<char *>(security->decryption(source));
    //将解密信息装载至response
    loadResponse(source_, env->NewStringUTF(dec));

    //释放资源
    env->ReleaseStringUTFChars(source_, source);
    env->ReleaseStringUTFChars(javaKey, ckey);
    delete (security);
    //将加密结果返回
    return response;
}


JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {
    vm->GetEnv((void**)&env,JNI_VERSION_1_6);
    if(env==NULL){
        LOGE("%s","初始化JNIEnv失败！");
    } else{
        //init
        jclass responseClass = env->FindClass(RESPONSE_CLASS_PATH);
        jmethodID responseConstructorMethodId = env->GetMethodID(responseClass,"<init>","()V");
        response = env->NewObject(responseClass,responseConstructorMethodId);

    }

    return JNI_VERSION_1_6;
}
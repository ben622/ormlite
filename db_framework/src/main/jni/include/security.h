//
// Created by eMapgo on 2019/1/5.
//

#ifndef ORMLITE_SECURITY_H
#define ORMLITE_SECURITY_H

#include <string>
namespace ormlite{
    class Security{
    private:
        //加密key
        char  *securityKey;
        char response;
    public:
        //构造函数
        Security(const char *key);
        //析构函数
        ~Security();
        void* encryption(const char *body);
        void* decryption(const char *body);
    };
}
#endif //ORMLITE_SECURITY_H

cmake_minimum_required(VERSION 3.4.1)

project("ormlite")


#设置C/C++文件主目录
set(ROOT ${CMAKE_SOURCE_DIR}/src/main/jni)
#设置C/C++头文件目录
include_directories(${ROOT}/include)

add_library(ormlite
            SHARED
            ${ROOT}/security.cpp)

find_library(log-lib
             log)

target_link_libraries(ormlite
                      ${log-lib})

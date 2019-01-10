package com.ben.android.ormlite.db_framework.dbcore.synchronize;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/7
 * @desc 多线程检查
 */
public class Condition {

    public static class InitCondition{
        public InitState state = InitState.UNINIT;
    }
    public static class CRUDCodition{

    }

    public  enum  InitState{
        START_INIT,INITING,INIT_FINSH,UNINIT,INIT_ERROR
    }
}

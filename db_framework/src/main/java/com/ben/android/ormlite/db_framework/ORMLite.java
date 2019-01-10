package com.ben.android.ormlite.db_framework;

import com.ben.android.ormlite.db_framework.ormcore.AORMQuery;
import com.ben.android.ormlite.db_framework.ormcore.AORMUpdate;
import com.ben.android.ormlite.db_framework.ormcore.ORMQuery;
import com.ben.android.ormlite.db_framework.ormcore.ORMUpdate;

import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public final class ORMLite extends BaseLite {

    public static ORMLite newLite() {
        return new ORMLite();
    }

    public <C extends AORMQuery<ORMQuery<ORMQuery, T>, T>, T> AORMQuery<C, T> query(Class<T> t) {
        AORMQuery<C, T> query = new ORMQuery<C, T>();
        return query;
    }

    public <C extends AORMUpdate<ORMUpdate<ORMUpdate, T>, T>, T> AORMUpdate<C, T> update(Class<T> t) {
        AORMUpdate<C, T> query = new ORMUpdate<C,T>();
        return query;
    }


    public void test() {
        //查询字段name中包含"张""王"的数据并返回全部
        List<User> allUser = ORMLite.newLite().query(User.class).in("name", new String[]{"张", "王"}).findAll();
        //查询字段name中包含"张""王"的数据并返回首条数据
        User firstUser = ORMLite.newLite().query(User.class).in("name", new String[]{"张", "王"}).findFirst();
        //查询用户中money大于1000且年龄在10-20之间的用户
        List<User> users = ORMLite.newLite().query(User.class).gt("money", 1000).between("age", 10, 20).findAll();

        ORMLite.newLite().update(User.class).gt("age", 20).update();

    }

}

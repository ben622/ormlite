package com.ben.android.ormlite.db_framework;

import android.content.Context;

import com.ben.android.ormlite.db_framework.ormcore.AORMCreate;
import com.ben.android.ormlite.db_framework.ormcore.AORMDelete;
import com.ben.android.ormlite.db_framework.ormcore.AORMQuery;
import com.ben.android.ormlite.db_framework.ormcore.AORMUpdate;
import com.ben.android.ormlite.db_framework.ormcore.ORMCreate;
import com.ben.android.ormlite.db_framework.ormcore.ORMDelete;
import com.ben.android.ormlite.db_framework.ormcore.ORMLiteOperator;
import com.ben.android.ormlite.db_framework.ormcore.ORMQuery;
import com.ben.android.ormlite.db_framework.ormcore.ORMUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/5
 */
public final class ORMLite extends BaseLite {
    public static void init(Context context) {
        init(context, null);
    }

    public static void init(Context context, ORMLiteConfiguration configuration) {
        BaseLite.init(context, configuration);
    }
    public static ORMLite newLite() {
        return new ORMLite();
    }
    public  static  <C extends AORMCreate<ORMCreate<ORMCreate,T>,T>,T> AORMCreate<C, T> insert(Class<T> t) {
        return ORMLiteOperator.createInsert(t);
    }
    public <C extends AORMQuery<ORMQuery<ORMQuery, T>, T>, T> AORMQuery<C, T> query(Class<T> t) {
        return ORMLiteOperator.createQuery(t);
    }

    public <C extends AORMUpdate<ORMUpdate<ORMUpdate, T>, T>, T> AORMUpdate<C, T> update(Class<T> t) {
        return ORMLiteOperator.createUpdate(t);
    }
    public  <C extends AORMDelete<ORMDelete<ORMDelete, T>, T>, T> AORMDelete<C, T> delete(Class<T> t) {
        return ORMLiteOperator.createDelete(t);
    }


    public void test() {
        //query
        //查询字段name中包含"张""王"的数据并返回全部
        List<User> allUser = ORMLite.newLite().query(User.class).in("name", new String[]{"张", "王"}).findAll();
        //查询字段name中包含"张""王"的数据并返回首条数据
        User firstUser = ORMLite.newLite().query(User.class).in("name", new String[]{"张", "王"}).findFirst();
        //查询用户中money大于1000且年龄在10-20之间的用户
        List<User> users = ORMLite.newLite().query(User.class).gt("money", 1000).between("age", 10, 20).findAll();

        //update
        ORMLite.newLite().update(User.class).gt("age", 20).update();

         //insert
        //插入一条数据
        User user = new User();
        ORMLite.newLite().insert(User.class).one(user).insert();
        //插入多条数据
        ArrayList<User> inserts = new ArrayList<>();
        inserts.add(new User());
        inserts.add(new User());
        inserts.add(new User());
        ORMLite.newLite().insert(User.class).mults(inserts).insert();

        //delete
        //删除用户名为test1的记录
        ORMLite.newLite().delete(User.class).equalTo("name", "test1").delete();
        //删除用户名为test1且年龄在30-50之间的记录
        ORMLite.newLite().delete(User.class).equalTo("name", "test1").between("age",30,50).delete();
    }

}

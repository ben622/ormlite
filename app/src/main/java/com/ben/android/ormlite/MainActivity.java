package com.ben.android.ormlite;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ben.android.ormlite.db_framework.ORMLite;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
            if (checkSelfPermission(perms[0]) == PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(perms[1]) == PackageManager.PERMISSION_DENIED
                    ) {
                requestPermissions(perms, 200);
            }
        }
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
        ORMLite.newLite().update(User.class).gt("age", 20).update(users.get(0));

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
        ORMLite.newLite().delete(User.class).eq("name", "test1").delete();
        //删除用户名为test1且年龄在30-50之间的记录
        ORMLite.newLite().delete(User.class).eq("name", "test1").between("age",30,50).delete();
    }


    public void onClick(View view) {
        ORMLite.init(getApplicationContext());

    }

    public void insert(View view) {
        User one = new User();
        one.setUserId(9999);
        one.setPhone("13512128888");
        one.setUserName("admin");

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
           User user = new User();
            user.setUserId(i);
            user.setPhone("159109103" + (i < 10 ? "0" + i : i));
            user.setUserName("test" + i);
            users.add(user);
        }

        long insert = ORMLite.newLite().insert(User.class).one(one).mults(users).insert();
        Log.e(TAG, "count:" + (users.size() + 1) + ",受响应的行数: " + insert);


    }

    public void update(View view) {
        User toUpdateEntity = new User();
        toUpdateEntity.setUserId(9999);
        toUpdateEntity.setPhone("18888888888");
        toUpdateEntity.setUserName("administrator");
        long update = ORMLite.newLite().update(User.class).eq("userId", 9999).update(toUpdateEntity);
        Log.e(TAG, "count:" + ( 1) + ",受响应的行数: " + update);
    }

    public void delete(View view) {
        //删除Id大于1小于5的数据
        ORMLite.newLite().delete(User.class)
                .gt("userId", 1)
                .lt("userId", 5)
                .delete();
    }
}

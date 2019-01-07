package com.ben.android.ormlite;

import com.ben.android.ormlite.db_framework.annotation.Column;
import com.ben.android.ormlite.db_framework.annotation.Table;

import java.util.List;

@Table("tb_user")
public class User {
    @Column(primaryKey = true)
    private int userId;
    @Column
    private String phone;
    @Column
    private String userName;


    @Table("tb_order")
    class Order{
        @Column(primaryKey = true)
        private String orderId;
        @Column
        private String orderName;

        @Column(foreignKey = true)
        private User user;


        @Column(foreignKey = true,foreignTableName = "tb_user",foreignTableColumnName = "userId")
        private List<User> users;

    }

    /**
     *
     * select * from order as o where o.user_id  = u.userid
     *
     * userid phone username
     *
     * orderid orderName user_id
     *
     *
     *
     *
     */

}

package com.ben.android.ormlite;

import com.ben.android.ormlite.db_framework.annotation.Column;
import com.ben.android.ormlite.db_framework.annotation.Table;

import java.util.List;

@Table("tb_user")
public class User {
    @Column(primaryKey = true)
    private int userId;
    @Column(value = "tb_phone")
    private String phone;
    @Column
    private String userName;



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

package com.ben.android.ormlite;

import com.ben.android.ormlite.db_framework.annotation.Column;
import com.ben.android.ormlite.db_framework.annotation.Table;

@Table(value = "tb_order")
public class Order {
    @Column
    private long orderId;
    @Column
    private String orderName;
    @Column
    private String orderDesc;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}

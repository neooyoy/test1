package com.designPattern.priciple.srp;

//协议接通接口
public interface IConnectionManager {
    //拨打
    public void dail(String phoneNumber);

    //挂断
    public void hangup();


}
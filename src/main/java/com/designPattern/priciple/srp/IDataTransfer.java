package com.designPattern.priciple.srp;

//数据传送接口: 依赖协议接通接口
public interface IDataTransfer{

    //数据传送
    public void DataTransfer(IConnectionManager connectionManager);
}

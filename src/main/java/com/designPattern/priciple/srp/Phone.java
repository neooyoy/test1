package com.designPattern.priciple.srp;

//单一职责原则： 不要有超过一个引起变化的原因

//终点：变化原因

public class Phone implements IConnectionManager, IDataTransfer {

    @Override
    public void dail(String phoneNumber) {

    }

    @Override
    public void hangup() {
    }

    @Override
    public void DataTransfer(IConnectionManager connectionManager) {

    }

    private void test(int... x) {
        for (int y : x) {
            System.out.println(y);
        }
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone() {
    }
}



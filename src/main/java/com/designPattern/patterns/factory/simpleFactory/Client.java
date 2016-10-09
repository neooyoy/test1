package com.designPattern.patterns.factory.simpleFactory;

public class Client {
    private static AFactory abstractFactory = null;
    private static AProduct product1;
    private static AProduct product2;

    public static void main(String[] args) {
        abstractFactory = new Factory1();

        product1 = abstractFactory.createProduct(Product1.class);
        product1.method1();
        product2 = abstractFactory.createProduct(Product2.class);
        product2.method1();
    }
}
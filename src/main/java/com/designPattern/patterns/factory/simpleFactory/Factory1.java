package com.designPattern.patterns.factory.simpleFactory;

public class Factory1 extends AFactory {
    public <T extends AProduct> T createProduct(Class<T> c) {
        AProduct abstractProduct = null;
        try {
            abstractProduct = (AProduct) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) abstractProduct;
    }
}
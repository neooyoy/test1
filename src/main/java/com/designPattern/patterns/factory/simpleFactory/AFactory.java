package com.designPattern.patterns.factory.simpleFactory;

public abstract class AFactory {
    public abstract <T extends AProduct> T createProduct(Class<T> c);
}
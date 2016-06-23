package com.test.fangxing;

import com.test.abstractAndInterface.TestIterator;

public interface TestGeneratorInterface<T> extends TestIterator {
    public abstract TestContainer<String, Integer> containernext();

    public TestIterator<T> generator();
}
package com.test.fangxing.impl;

import com.test.abstractAndInterface.TestIterator;
import com.test.fangxing.TestContainer;
import com.test.fangxing.TestGeneratorInterface;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestGeneratorInterfaceImpl<T> implements TestGeneratorInterface<T>{

    private int size;

    public TestContainer<String, Integer> containernext(){
        TestContainer<String, Integer> containernext = new TestContainer<String, Integer>();
        return containernext;
    }

    public TestIterator<T> generator(){
        return new Itr();
    }

    public T next(){
        return (T) new Itr();
    }

    private class Itr implements TestIterator<T> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public T next() {
            int i = cursor;
            Object[] elementData = new Object[10];
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }
    }
}



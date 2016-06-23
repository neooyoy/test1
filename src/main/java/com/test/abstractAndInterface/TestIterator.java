package com.test.abstractAndInterface;

import java.util.NoSuchElementException;

public interface TestIterator<T>{
    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    T next();
}
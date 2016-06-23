package com.test.fangxing;

public class TestContainer<K, V>{
    private K key;

    private V value;

    public TestContainer() {
    }

    public TestContainer(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    public static void main(String[] args) {
        TestContainer<String, String> c1 = new TestContainer<String, String>("name", "findingsea");
        TestContainer<String, Integer> c2 = new TestContainer<String, Integer>("age", 24);
        TestContainer<Double, Double> c3 = new TestContainer<Double, Double>(1.1, 2.2);
        System.out.println(c1.getKey() + " : " + c1.getValue());
        System.out.println(c2.getKey() + " : " + c2.getValue());
        System.out.println(c3.getKey() + " : " + c3.getValue());
    }
}
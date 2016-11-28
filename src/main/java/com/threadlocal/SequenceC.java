package com.threadlocal;


/**
 * 每个线程是相互独立的，同样是static变量，对于不同线程而言，没有被共享，
 * 而是每个现场冷各一份，保证了线程安全。
 *
 * ThreadLocal为每一个线程提供了一个独立的副本。
 *
 * 当在一个类中使用static成员变量的时候，要考虑线程安全。
 */
public class SequenceC implements Sequence {

    private static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceC();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
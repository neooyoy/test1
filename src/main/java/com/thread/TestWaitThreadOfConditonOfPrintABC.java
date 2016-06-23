package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestWaitThreadOfConditonOfPrintABC {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private String curType = "A";
    private Integer countA = 10;
    private Integer countB = 10;
    private Integer countC = 10;

    class PrintA extends Thread {
        @Override
        public void run() {
            printA();
        }

        public void printA() {
            while (countA > 0) {
                lock.lock();
                try {
                    //获取打印条件
                    while (!curType.equals("A")) {
                        conditionA.await();
                    }
                    System.out.print("A");
                    curType = "B";
                    countA--;
                    conditionB.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class PrintB extends Thread {
        @Override
        public void run() {
            printB();
        }

        public void printB() {
            while (countB > 0) {
                lock.lock();
                try {
                    //获取打印条件
                    while (!curType.equals("B")) {
                        conditionB.await();
                    }
                    System.out.print("B");
                    curType = "C";
                    countB--;
                    conditionC.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    class PrintC extends Thread {
        @Override
        public void run() {
            printC();
        }

        public void printC() {
            while (countC > 0) {
                lock.lock();
                try {
                    //获取打印条件
                    while (!curType.equals("C")) {
                        conditionC.await();
                    }
                    System.out.print("C");
                    curType = "A";
                    countC--;
                    conditionA.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static void main(String[] args) {
        TestWaitThreadOfConditonOfPrintABC test = new TestWaitThreadOfConditonOfPrintABC();
        PrintA printA = test.new PrintA();
        PrintB printB = test.new PrintB();
        PrintC printC = test.new PrintC();
        printA.start();
        printB.start();
        printC.start();
    }

}


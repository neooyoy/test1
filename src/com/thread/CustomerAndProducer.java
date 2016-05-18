package com.thread;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomerAndProducer {
    private Integer count = 10;
    private PriorityQueue<Integer> productQueue = new PriorityQueue<Integer>(count);;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    class Customer implements Runnable {
        @Override
        public void run() {
            customer();
        }

        public void customer() {
            while (true) {
                lock.lock();
                try {
                    while (productQueue.isEmpty()) {
                        System.out.println("没有商品，等待消费");
                        notEmpty.await();
                    }
                    productQueue.poll();
                    notFull.signal();
                    Thread.sleep(500);
                    System.out.println("从队列取走一个元素，队列剩余" + productQueue.size() + "个元素");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    class Producer implements Runnable{
        @Override
        public void run() {
            produce();
        }

        public void produce() {
            while (true) {
                lock.lock();
                try {
                    while (productQueue.size() == count) {
                        System.out.println("商品队列已满，等待生产");
                        notFull.await();
                    }
                    productQueue.offer(1);
                    notEmpty.signal();
                    Thread.sleep(1000);
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (count - productQueue.size()));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args){
        CustomerAndProducer c = new CustomerAndProducer();
        Customer customer = c.new Customer();
        Producer producer = c.new Producer();
        new Thread(customer).start();
        new Thread(producer).start();
    }

}


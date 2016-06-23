package com.thread;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadOfCustomerAndProducer {
    private Integer count = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(count);

    class Customer implements Runnable {
        @Override
        public void run() {
            customer();
        }

        private void customer() {
            while (true) {
                try {
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            System.out.println("没有商品，等待消费");
                            try {
                                queue.wait();
                            }catch (InterruptedException e){
                                e.printStackTrace();
                                queue.notify();
                            }
                        }

                        queue.poll();
                        Thread.sleep(500);
                        queue.notify();
                        System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    queue.notify();
                }
            }
        }
    }


    class Producer implements Runnable {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    synchronized (queue) {
                        while (queue.size() == count) {
                            System.out.println("商品队列已满，等待生产");
                            try {
                                queue.wait();
                            }catch (InterruptedException e){
                                e.printStackTrace();
                                queue.notify();
                            }
                        }

                        queue.offer(1);
                        Thread.sleep(500);
                        queue.notify();
                        System.out.println("向队列取中插入一个元素，队列剩余空间：" + (count - queue.size()));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    queue.notify();
                }
            }
        }
    }

    public static void main(String[] args){
        ThreadOfCustomerAndProducer t = new ThreadOfCustomerAndProducer();
        Producer producer = t.new Producer();
        Customer customer = t.new Customer();

        new Thread(producer).start();
        new Thread(customer).start();
    }


}
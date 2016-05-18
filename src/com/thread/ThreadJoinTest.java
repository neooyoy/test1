package com.thread;

public class ThreadJoinTest {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程开始运行");

        Thread1 thread1 = new Thread1("a");
        Thread1 thread2 = new Thread1("b");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
    }


}

class Thread1 extends Thread{
    private String name;

    public Thread1(String name){
        super(name);
        this.name = name;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + "线程开始运行");

        for (int i=0; i<5; i++){
            try{
                sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }
}

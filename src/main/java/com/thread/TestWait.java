package com.thread;

/*Obj.wait()，与Obj.notify()必须要与synchronized(Obj)一起使用，也就是wait,与notify是针对已经获取了Obj锁进行操作，
    从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内。
    从功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。
    直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。
    相应的notify()就是对对象锁的唤醒操作。
    但有一点需要注意的是notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，
    自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
    这样就提供了在线程间同步、唤醒的操作。Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，
    主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制。*/


/*sleep方法
sleep()使当前线程进入停滞状态（阻塞当前线程），让出CUP的使用、目的是不让当前线程独自霸占该进程所获的CPU资源，以留一定时间给其他线程执行的机会;
sleep()是Thread类的Static(静态)的方法；因此他不能改变对象的机锁，所以当在一个Synchronized块中调用Sleep()方法是，
        线程虽然休眠了，但是对象的机锁并木有被释放，其他线程无法访问这个对象（即使睡着也持有对象锁）。
在sleep()休眠时间期满后，该线程不一定会立即执行，这是因为其它线程可能正在运行而且没有被调度为放弃执行，除非此线程具有更高的优先级。*/


/*wait方法
wait()方法是Object类里的方法；当一个线程执行到wait()方法时，它就进入到一个和该对象相关的等待池中，
        同时失去（释放）了对象的机锁（暂时失去机锁，wait(long timeout)超时时间到后还需要返还对象锁）；其他线程可以访问；
wait()使用notify或者notifyAlll或者指定睡眠时间来唤醒当前等待池中的线程。
wait()必须放在synchronized block中，否则会在program runtime时扔出”java.lang.IllegalMonitorStateException“异常*/

/*A．无论synchronized关键字加在方法上还是对象上，它取得的锁都是对象，而不是把一段代码或函数当作锁――而且同步方法很可能还会被其他线程的对象访问。
B．每个对象只有一个锁（lock）与之相关联。
C．实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestWait {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        TestWaitThread aThread = new TestWaitThread("a", c, a);
        TestWaitThread bThread = new TestWaitThread("b", a, b);
        TestWaitThread cThread = new TestWaitThread("c", b, c);

        aThread.start();
        try {
            aThread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bThread.start();
        cThread.start();
    }
}

class TestWaitThread extends Thread {
    private String name;

    private Object pre;

    private Object self;

    private Integer count = 10;

    public TestWaitThread(String name, Object pre, Object self) {
        super(name);
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    public void run() {
        while (count > 0) {
            synchronized (pre) {
                synchronized (self) {
                    self.notify();

                    count--;
                    System.out.print(name);
                }

                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

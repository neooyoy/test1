package com.thread;

/*实际上所有的多线程代码都是通过运行Thread的start()方法来运行的。因此，不管是扩展Thread类还是实现Runnable接口来实现多线程，
        最终还是通过Thread的对象的API来控制线程的，熟悉Thread类的API是进行多线程编程的基*/

//Thread和Runnable的区别
//1.如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享
//实现Runnable接口比继承Thread类所具有的优势：
//        1）：适合多个相同的程序代码的线程去处理同一个资源
//        2）：可以避免java中的单继承的限制
//        3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立


//这里要注意每个线程都是用同一个实例化对象，如果不是同一个，效果就和上面的一样了！


/*
总结：
    实现Runnable接口比继承Thread类所具有的优势：
    1）：适合多个相同的程序代码的线程去处理同一个资源
    2）：可以避免java中的单继承的限制
    3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
*/


//提醒一下大家：main方法其实也是一个线程。在java中所以的线程都是同时启动的，至于什么时候，哪个先执行，完全看谁先得到CPU的资源。


//线程状态转换
/*1、新建状态（New）：新创建了一个线程对象。
2、就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。
3、运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。
4、阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
（一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。
（二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
（三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。
        当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。
5、死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。*/


/*线程的调度
1、调整线程优先级：Java线程有优先级，优先级高的线程会获得较多的运行机会。

Java线程的优先级用整数表示，取值范围是1~10，Thread类有以下三个静态常量：
static int MAX_PRIORITY
线程可以具有的最高优先级，取值为10。
static int MIN_PRIORITY
线程可以具有的最低优先级，取值为1。
static int NORM_PRIORITY
分配给线程的默认优先级，取值为5。
Thread类的setPriority()和getPriority()方法分别用来设置和获取线程的优先级。

2、线程睡眠：Thread.sleep(long millis)方法，使线程转到阻塞状态。millis参数设定睡眠的时间，以毫秒为单位。
当睡眠结束后，就转为就绪（Runnable）状态。sleep()平台移植性好。

3、线程等待：Object类中的wait()方法，导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 唤醒方法。
这个两个唤醒方法也是Object类中的方法，行为等价于调用 wait(0) 一样。

4、线程让步：Thread.yield() 方法，暂停当前正在执行的线程对象，把执行机会让给相同或者更高优先级的线程。

5、线程加入：join()方法，等待其他线程终止。在当前线程中调用另一个线程的join()方法，
则当前线程转入阻塞状态，直到另一个进程运行结束，当前线程再由阻塞转为就绪状态。

6、线程唤醒：Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。
选择是任意性的，并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，在对象的监视器上等待。
直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；
例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。类似的方法还有一个notifyAll()，唤醒在此对象监视器上等待的所有线程。
注意：Thread中suspend()和resume()两个方法在JDK1.5中已经废除，不再介绍。因为有死锁倾向*/


public class TestExtendsThread extends Thread {
    String name;
    private int count = 15;

    public TestExtendsThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.name + "线程运行; count=" + (count--));
        }
    }

    public static void main(String[] args) {
        try {
//            TestExtendsThread thread = new TestExtendsThread("a");
//            TestExtendsThread thread1 = new TestExtendsThread("b");
            TestImplementsRunnable thread2 = new TestImplementsRunnable();
//            TestImplementsRunnable thread3 = new TestImplementsRunnable("d");
//            thread.start();
//            thread1.start();
//            thread2.run();
//            thread3.run();

            new Thread(thread2, "c").start();
            new Thread(thread2, "d").start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class TestImplementsRunnable implements Runnable {
    private String name;
    private int count = 15;

    public TestImplementsRunnable() {
    }

    public TestImplementsRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+ "线程运行; count=" + (count--));
        }
    }
}
package com.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/*java.util.Timer计时器有管理任务延迟执行("如1000ms后执行任务")以及周期性执行("如每500ms执行一次该任务")。
    但是，Timer存在一些缺陷，因此你应该考虑使用ScheduledThreadPoolExecutor作为代替品,Timer对调度的支持是基于绝对时间,而不是相对时间的，
    由此任务对系统时钟的改变是敏感的;ScheduledThreadExecutor只支持相对时间。

    Timer的另一个问题在于，如果TimerTask抛出未检查的异常，Timer将会产生无法预料的行为。
    Timer线程并不捕获异常，所以TimerTask抛出的未检查的异常会终止timer线程。
    这种情况下，Timer也不会再重新恢复线程的执行了;它错误的认为整个Timer都被取消了。
    此时，已经被安排但尚未执行的TimerTask永远不会再执行了，新的任务也不能被调度了。*/

public class TestTimerAndScheduledExecutorService {

    private static int number = 0;

    private static long start;

    private Timer timer;

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        };

        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行时间" + (System.currentTimeMillis() - start));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行时间" + (System.currentTimeMillis() - start));
            }
        };

        Timer timer = new Timer();

        try {
            timer.schedule(timerTask, 1000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            timer.schedule(timerTask1, 1000);

            timer.schedule(timerTask2, 3000);

        }


        start = System.currentTimeMillis();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleWithFixedDelay(timerTask1, 0, 1000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(timerTask2, 0, 1000, TimeUnit.MILLISECONDS);
    }
}



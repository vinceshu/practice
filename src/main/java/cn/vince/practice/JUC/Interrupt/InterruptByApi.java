package cn.vince.practice.JUC.Interrupt;

import cn.vince.practice.JUC.threadPool.CustomizeExecutor;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author: vince.shu
 * @description: Thread API 实现线程中断的方式
 * @date: 2022/6/4 15:22
 * @version: 1.0
 */
public class InterruptByApi {

    private static final CustomizeExecutor customizeExecutor = new CustomizeExecutor();

    public  static void main(String[] args) {
        Object object = new Object();

        try {
            synchronized (object) {
                object.wait();

                object.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //apiInterrupt();
    }

    public static void apiInterrupt() {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t api 被修改为true， 程序停止");
                    break;
                }
                System.out.println(" hello api");
            }
        }, "t1");
        t1.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t1::interrupt, "t2").start();
    }


}

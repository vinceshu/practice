package cn.vince.practice.JUC.Interrupt;

import cn.vince.practice.JUC.threadPool.CustomizeExecutor;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: vince.shu
 * @description: volatile 实现线程中断的方式
 * @date: 2022/6/3 23:50
 * @version: 1.0
 */
public class InterruptByAtomic {

    private static final CustomizeExecutor customizeExecutor = new CustomizeExecutor();


    public static void main(String[] args) {
        atomicInterrupt();
    }

    /**
     * @author vinceshu
     * @date  23:51
     * @description 使用volatile关键词实现线程中断
     */

    static volatile AtomicBoolean isStop = new AtomicBoolean(false);

    public static void atomicInterrupt() {
        customizeExecutor.execute(() -> {
            while (true) {
                if (isStop.get()) {
                    System.out.println(Thread.currentThread().getName() + "\t volatile 被修改为true， 程序停止");
                    break;
                }
                System.out.println(" hello volatile");
            }
        });

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customizeExecutor.execute(() -> {
            isStop.set(true);
        });

        customizeExecutor.destroy();
    }

}

package cn.vince.practice.JUC.Interrupt;

import cn.vince.practice.JUC.threadPool.CustomizeExecutor;

/**
 * @author: vince.shu
 * @description: volatile 实现线程终端的方式
 * @date: 2022/6/3 23:50
 * @version: 1.0
 */
public class InterruptByVolatile {

    private static CustomizeExecutor customizeExecutor = new CustomizeExecutor();


    public static void main(String[] args) {
        volatileInterrupt();
    }

    /**
     * @author vinceshu
     * @date  23:51
     * @description 使用volatile关键词实现线程中断
     */

    static volatile boolean isStop = false;

    public static void volatileInterrupt() {
        customizeExecutor.execute(() -> {
            while (true) {
                if (isStop) {
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
            isStop = true;
        });

        customizeExecutor.destroy();
    }

}

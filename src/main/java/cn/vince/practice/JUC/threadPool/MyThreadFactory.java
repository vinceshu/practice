package cn.vince.practice.JUC.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author vinceshu
 * @date 2022/6/4 0:57
 * @description TODO
 */
public class MyThreadFactory implements ThreadFactory {
    private static final Logger log = LoggerFactory.getLogger(MyThreadFactory.class);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    public MyThreadFactory(String prefix) {
        SecurityManager s = System.getSecurityManager();
        this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = this.namePrefix + this.threadNumber.getAndIncrement();
        log.info("newThread: {}", name);
        Thread t = new Thread(this.group, r, name, 0L);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }

        if (t.getPriority() != 5) {
            t.setPriority(5);
        }

        return t;
    }
}
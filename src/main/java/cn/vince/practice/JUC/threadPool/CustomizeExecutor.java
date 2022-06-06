package cn.vince.practice.JUC.threadPool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: vince.shu
 * @description: 自定义线程池
 * @date: 2022/6/4 0:09
 * @version: 1.0
 */
@Slf4j
public class CustomizeExecutor implements Executor {

    private final ThreadPoolExecutor executor;
    private static final int CORE_SIZE = 10;
    private static final int MAX_SIZE = 20;
    private static final int TTL = 1;
    private static final int QUEUE = 50;
    private static final String PREFIX = "CustomizeExecutor";

    public CustomizeExecutor() {
        this.executor = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, (long)TTL, TimeUnit.MINUTES, new ArrayBlockingQueue(QUEUE), new MyThreadFactory(PREFIX));
    }

    public CustomizeExecutor(int core, int max, int ttl, int queue, String prefix) {
        this.executor = new ThreadPoolExecutor(core, max, (long)ttl, TimeUnit.MINUTES, new ArrayBlockingQueue(queue), new MyThreadFactory(prefix));
    }


    @Override
    public void execute(Runnable command) {
        log.debug("async submit task, current pool size:{}, execute task thread count:{}, total task count:{}, queue size:{}, completed task count:{}", new Object[]{this.executor.getPoolSize(), this.executor.getActiveCount(), this.executor.getTaskCount(), this.executor.getQueue(), this.executor.getCompletedTaskCount()});
        this.executor.execute(new SafeRunnable(command) {
        });
    }

    public void destroy() {
        log.info("shutdown delegateExecutor");
        this.executor.shutdown();
    }
}

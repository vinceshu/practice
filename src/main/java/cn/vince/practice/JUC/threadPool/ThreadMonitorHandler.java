/*
package cn.vince.practice.JUC.threadPool;


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.DateUtils;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


*/
/**
 * @author vinceshu
 * @date 2022/6/4 22:31
 * @description 线程池监控
 *//*

@Slf4j
@Component
public class ThreadMonitorHandler extends IJobHandler {

    @Autowired
    private List<Executor> executorList;

    @Autowired
    private ApplicationContext applicationContext;

    private Map<Object, String> beanCache = new HashMap<>();

    @Autowired
    private RedissonClient redissonClient;


    */
/**
     * 线程池监控上报
     *//*

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExecutorReport {
        //---------------------------------------------------------------------
        // 核心参数
        //---------------------------------------------------------------------
        */
/**
         * 核心线程数
         *//*

        private Integer coreSize;
        */
/**
         * 最大线程数
         *//*

        private Integer maximumSize;
        */
/**
         * 线程池当前线程数 (有锁)
         *//*

        private Integer poolSize;
        */
/**
         * 活跃线程数 (有锁)
         *//*

        private Integer activeSize;
        */
/**
         * 同时进入池中的最大线程数 (有锁)
         *//*

        private Integer largestPoolSize;
        */
/**
         * 线程池中执行任务总数量 (有锁)
         *//*

        private Long completedTaskCount;

        */
/**
         * 队列元素个数
         *//*

        private Integer queueSize;
        */
/**
         * 队列类型
         *//*

        private String queueType;
        */
/**
         * 队列剩余容量
         *//*

        private Integer queueRemainingCapacity;
        */
/**
         * 队列容量
         *//*

        private Integer queueCapacity;


        //---------------------------------------------------------------------
        // 扩展参数
        //---------------------------------------------------------------------
        */
/**
         * 线程类型 使用全路径类名
         *//*

        private String executorType;
        */
/**
         * 线程在容器中的名称
         *//*

        private String beanName;

        */
/**
         * 当前负载
         *//*

        private String currentLoad;
        */
/**
         * 峰值负载
         *//*

        private String peakLoad;


        */
/**
         * 机器IP
         *//*

        private String host;
        */
/**
         * 内存占比
         *//*

        private String memoryProportion;
        */
/**
         * JVM空闲内存
         *//*

        private String freeMemory;

        */
/**
         * 当前时间戳 s
         *//*

        private Integer timestamp;
        */
/**
         * 客户端上报时间
         *//*

        private String clientLastRefreshTime;


        //---------------------------------------------------------------------
        // 其他
        //---------------------------------------------------------------------
        @Override
        public String toString() {
            return "线程状态:\n" +
                    "类型:" + this.executorType + "\n" +
                    "线程在容器中的名称:" + this.beanName + "\n" +
                    "核心线程数:" + this.coreSize + "\n" +
                    "最大线程数:" + this.maximumSize + "\n" +
                    "线程池当前线程数:" + this.poolSize + "\n" +
                    "活跃线程数:" + this.activeSize + "\n" +
                    "同时进入池中的最大线程数:" + this.largestPoolSize + "\n" +
                    "线程池中执行任务总数量:" + this.completedTaskCount + "\n" +
                    "队列元素个数:" + this.queueSize + "\n" +
                    "队列类型:" + this.queueType + "\n" +
                    "队列剩余容量:" + this.queueRemainingCapacity + "\n" +
                    "队列容量:" + this.queueCapacity + "\n" +
                    "当前负载:" + this.currentLoad + "\n" +
                    "峰值负载:" + this.peakLoad + "\n" +
                    "机器IP:" + this.host + "\n" +
                    "内存占比:" + this.memoryProportion + "\n" +
                    "JVM空闲内存:" + this.freeMemory + "\n" +
                    "当前时间戳(s):" + this.timestamp + "\n" +
                    "客户端上报时间:" + this.clientLastRefreshTime;
        }

    }

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        RLock lock = redissonClient.getLock("test");

        lock.tryLock(5L, 1L, TimeUnit.SECONDS);

        if (CollectionUtils.isEmpty(executorList)) {
            XxlJobLogger.log(">>>>>> 未获取到线程池");
            return ReturnT.SUCCESS;
        }
        // 遍历线程池
        for (Executor executor : executorList) {
            if (executor instanceof CustomizeExecutor) {
                CustomizeExecutor customizeExecutor = (CustomizeExecutor) executor;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) getPrivateField(customizeExecutor, "executor");

                String executorType = executor.getClass().getName();
                String beanName = getExecutorBeanNameForInstance(executor);
                ExecutorReport executorReport = buildThreadPoolExecutorReport(threadPoolExecutor, executorType, beanName);
                XxlJobLogger.log(">>>>> {0}", executorReport.toString());
                log.info("threadMonitorHandler: {} ", executorReport);
            } else if (executor instanceof ThreadPoolTaskExecutor) {
                ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) executor;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) getPrivateField(threadPoolTaskExecutor, "threadPoolExecutor");

                String executorType = executor.getClass().getName();
                String beanName = getExecutorBeanNameForInstance(executor);

                ExecutorReport executorReport = buildThreadPoolExecutorReport(threadPoolExecutor, executorType, beanName);
                XxlJobLogger.log(">>>>> {0}", executorReport.toString());
                log.info("threadMonitorHandler: {} ", executorReport);
            }
        }
        return ReturnT.SUCCESS;
    }

    */
/**
     * jdk提供的
     *//*

    private ExecutorReport buildThreadPoolExecutorReport(ThreadPoolExecutor threadPoolExecutor, String executorType, String beanName) {
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();

        // 核心线程数
        int corePoolSize = threadPoolExecutor.getCorePoolSize();
        // 最大线程数
        int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
        // 线程池当前线程数 (有锁)
        int poolSize = threadPoolExecutor.getPoolSize();
        // 活跃线程数 (有锁)
        int activeCount = threadPoolExecutor.getActiveCount();
        // 同时进入池中的最大线程数 (有锁)
        int largestPoolSize = threadPoolExecutor.getLargestPoolSize();
        // 线程池中执行任务总数量 (有锁)
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();


        // 队列元素个数
        int queueSize = queue.size();
        // 队列类型
        String queueType = queue.getClass().getSimpleName();
        // 队列剩余容量
        int remainingCapacity = queue.remainingCapacity();
        // 队列容量
        int queueCapacity = queueSize + remainingCapacity;

        // 当前负载
        String currentLoad = divide(activeCount, maximumPoolSize) + "";
        // 峰值负载
        String peakLoad = divide(largestPoolSize, maximumPoolSize) + "";

        ExecutorReport report = ExecutorReport.builder()
                //
                .coreSize(corePoolSize)
                .maximumSize(maximumPoolSize)
                .poolSize(poolSize)
                .activeSize(activeCount)
                .largestPoolSize(largestPoolSize)
                .completedTaskCount(completedTaskCount)
                // 队列
                .queueSize(queueSize)
                .queueType(queueType)
                .queueCapacity(queueCapacity)
                .queueRemainingCapacity(remainingCapacity)
                // 负载
                .currentLoad(currentLoad)
                .peakLoad(peakLoad)
                // 其他
                .clientLastRefreshTime(DateUtils.formatDate(new Date()))
                .timestamp((int) (System.currentTimeMillis() / 1000))
                .executorType(executorType)
                .beanName(beanName)
                .build();

        return supplement(report);
    }

    */
/**
     * 获取私有成员变量的值
     *
     * @param instance  实例
     * @param filedName 字段名称
     * @return 字段
     *//*

    private Object getPrivateField(Object instance, String filedName) throws NoSuchFieldException, IllegalAccessException {
        Field field = instance.getClass().getDeclaredField(filedName);
        field.setAccessible(true);
        return field.get(instance);
    }

    private int divide(int num1, int num2) {
        return ((int) (Double.parseDouble(num1 + "") / Double.parseDouble(num2 + "") * 100));
    }

    */
/**
     * 字节转换
     *//*

    private String getPrintSize(long size) {
        long covertNum = 1024;
        if (size < covertNum) {
            return size + "B";
        } else {
            size = size / covertNum;
        }
        if (size < covertNum) {
            return size + "KB";
        } else {
            size = size / covertNum;
        }
        if (size < covertNum) {
            size = size * 100;
            return (size / 100) + "." + (size % 100) + "MB";
        } else {
            size = size * 100 / covertNum;
            return (size / 100) + "." + (size % 100) + "GB";
        }
    }


    private ExecutorReport supplement(ExecutorReport poolRunStateInfo) {
        // 内存占比: 使用内存 / 最大内存
        Runtime runtime = Runtime.getRuntime();
        String memoryProportion =
                "已分配: " + getPrintSize(runtime.totalMemory()) +
                " / 最大可用: " + getPrintSize(runtime.maxMemory()) + "\n";
        poolRunStateInfo.setCurrentLoad(poolRunStateInfo.getCurrentLoad() + "%");
        poolRunStateInfo.setPeakLoad(poolRunStateInfo.getPeakLoad() + "%");
        try {
            poolRunStateInfo.setHost(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ignored) {
        }
        poolRunStateInfo.setMemoryProportion(memoryProportion);

        poolRunStateInfo.setFreeMemory(getPrintSize(runtime.freeMemory()));
        return poolRunStateInfo;
    }

    */
/**
     * 根据实例获取该实例在容器中的名称
     *
     * @param instance 实例
     * @return 实例在容器中的名称
     *//*

    private String getExecutorBeanNameForInstance(Object instance) {
        if (instance == null) {
            return null;
        }
        if (beanCache.containsKey(instance)) {
            return beanCache.get(instance);
        }
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Executor.class);
        for (String beanName : beanNamesForType) {
            beanCache.put(applicationContext.getBean(beanName), beanName);
        }
        // 缓存中获取
        String beanName = beanCache.get(instance);
        if (StringUtils.isEmpty(beanName)) {
            // 防止击穿缓存
            beanCache.put(instance, null);
        }
        return beanName;
    }

}
*/

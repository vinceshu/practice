package cn.vince.practice.JUC.threadPool;

import cn.vince.practice.Utils.BSIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author vinceshu
 * @date 2022/6/4 1:31
 * @description TODO
 */
public class SafeRunnable implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(SafeRunnable.class);
    private Runnable runnable;
    private String bsid;

    public SafeRunnable(Runnable runnable) {
        Objects.requireNonNull(runnable);
        this.runnable = runnable;
        this.bsid = BSIDUtils.getCurBsid();
    }

    @Override
    public void run() {
        BSIDUtils.putRelationBsid(this.bsid);

        try {
            this.runnable.run();
        } catch (Throwable var5) {
            log.error("线程池执行任务异常 error occurred in task", var5);
        } finally {
            BSIDUtils.removeRelationBsid();
        }

    }
}

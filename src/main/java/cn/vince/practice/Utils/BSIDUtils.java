package cn.vince.practice.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class BSIDUtils {
    private static final Logger log = LoggerFactory.getLogger(BSIDUtils.class);
    private static final String BSID = "bsid";

    public BSIDUtils() {
    }

    public static String getCurBsid() {
        String old = MDC.get("bsid");
        String news = generatorBsid();
        if (old == null) {
            log.debug("未获取到父线程的bsid，从新生成一个新的bsid：[{}]", news);
        } else {
            log.debug("获取到父线程的bsid：[{}]", old);
        }

        return old == null ? news : old;
    }

    private static String generatorBsid() {
        return UUID.randomUUID().toString();
    }

    public static void putRelationBsid(String bsid) {
        MDC.put("bsid", bsid);
    }

    public static void removeRelationBsid() {
        MDC.remove("bsid");
    }
}
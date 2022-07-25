package cn.vince.practice.interview.javaBase;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: vince.shu
 * @date: 2022/6/9 0:46
 * @description: TODO
 * @version: 1.0
 */
@Slf4j
public class StringPool {

    public static void main(String[] args) {
        String  s1 = new StringBuilder("ali").append("baba").toString();
        System.out.println(s1);
        System.out.println(s1.intern());
        System.out.println(s1 == s1.intern());
        log.info("equals 1: {}", s1.equals(s1.intern()));

        String  s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2);
        System.out.println(s2.intern());
        System.out.println(s2 == s2.intern());

        log.info("equals 2: {}", s2==s2.intern());
    }
}

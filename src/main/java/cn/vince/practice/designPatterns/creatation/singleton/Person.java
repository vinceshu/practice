package cn.vince.practice.designPatterns.creatation.singleton;

import lombok.Builder;
import lombok.Data;

/**
 * @author: vince.shu
 * @description: 单例模式
 * @date: 2022/5/22 0:00
 * @version: 1.0
 */
@Data
@Builder
public class Person {

    private String name;

    private Integer age;

/*
    //防止指令重排，保证可见性
    private volatile static Person instance;

    */
/**
     * @author vinceshu
     * @date 2022/5/22 0:01
     * @description 构造器私有，外部无法实例化
     *//*

    private Person() {}

    */
/**
     * 双重检查， 先锁代码块，再检查是否已有对象
     *//*

    public static Person getPerson() {
        synchronized (Person.class) {
            //没有再创建
            if (instance == null) {
                instance = new Person();
            }
        }
        return instance;
    }
*/




    /**
     * 锁方法，锁颗粒度太大，效率低
     */
/*    public static synchronized Person getPerson() {

        //没有再创建
        if (instance == null) {
            instance = new Person();
        }
        return instance;
    }*/

}

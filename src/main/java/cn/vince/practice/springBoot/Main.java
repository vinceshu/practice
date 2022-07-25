package cn.vince.practice.springBoot;

import cn.vince.practice.springBoot.configuration.MyConfiguration;
import cn.vince.practice.springBoot.entity.UserBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        UserBean userBean = (UserBean)context.getBean("getUserBean");
        System.out.println(userBean.toString());
    }
}

package cn.vince.practice.springBoot.configuration;

import cn.vince.practice.springBoot.entity.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public UserBean getUserBean() {
        UserBean userBean = new UserBean();
        userBean.setAge(18);
        userBean.setName("vinceshu");
        return userBean;
    }
}

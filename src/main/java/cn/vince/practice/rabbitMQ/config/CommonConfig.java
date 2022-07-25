package cn.vince.practice.rabbitMQ.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author: vince.shu
 * @date: 2022/6/18 15:01
 * @description: TODO
 * @version: 1.0
 */
@Configuration
@Slf4j
public class CommonConfig implements ApplicationContextAware {


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);
        rabbitTemplate.setReturnsCallback(returnedMessage -> {
            //日志记录
            log.error("消息发送到对了失败，响应码：{}， 交换机：{}， 路由key：{}， 消息：{}",
                    returnedMessage.getReplyCode(), returnedMessage.getExchange(), returnedMessage.getRoutingKey(),
                    returnedMessage.getMessage());
        });
    }
}

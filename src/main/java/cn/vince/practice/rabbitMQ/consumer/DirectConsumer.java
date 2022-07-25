package cn.vince.practice.rabbitMQ.consumer;

import cn.vince.practice.rabbitMQ.constants.MqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: vince.shu
 * @date: 2022/6/18 15:26
 * @description: TODO
 * @version: 1.0
 */
@Component
@Slf4j
public class DirectConsumer {

    /*@RabbitListener(bindings = {@QueueBinding(
            value = @Queue(value = MqConstants.DIRECT_QUEUE_NAME, durable = "true"),
            exchange = @Exchange(MqConstants.DIRECT_EXCHANGE_NAME),
            key = MqConstants.ROUTING_KEY
    )})*/
    @RabbitListener(queuesToDeclare = {@Queue(value = MqConstants.DIRECT_QUEUE_NAME, durable = "true")})
    public void receive(String message) {
        log.info("DirectConsumer receive message :{} ", message);
    }


}

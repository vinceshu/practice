package cn.vince.practice.rabbitMQ;


import cn.vince.practice.rabbitMQ.constants.MqConstants;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.SuccessCallback;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: vince.shu
 * @date: 2022/6/18 15:07
 * @description: TODO
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AmqpTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        //消息内容
        String message = " this is a message !";

        //准备correlationData
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        correlationData.getFuture().addCallback((SuccessCallback<CorrelationData.Confirm>) result -> {
            assert result != null;
            if (result.isAck()) {
                //ACK
                log.info("消息成功投递到交换机");
            } else {
                //NACK
                log.error("消息投递到交换机失败，消息id:{}", correlationData.getId());
            }

        }, ex -> {
            //失败。 可以做补偿、重发等操作
            log.error("发送消息失败, error:{}", ex);
        });

        //发送消息
        rabbitTemplate.convertAndSend(MqConstants.DIRECT_EXCHANGE_NAME, MqConstants.ROUTING_KEY, message, correlationData);

    }
}

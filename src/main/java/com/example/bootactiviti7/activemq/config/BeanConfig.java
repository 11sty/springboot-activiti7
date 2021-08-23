package com.example.bootactiviti7.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName BeanConfig.java
 * @Description TODO
 * @createTime 2021年08月23日 10:11:00
 */
@Configuration
public class BeanConfig {
    //定义存放消息
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("ActiveMQQueue");
    }
}
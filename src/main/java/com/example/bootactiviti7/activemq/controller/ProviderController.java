package com.example.bootactiviti7.activemq.controller;

import com.example.bootactiviti7.activemq.pojo.Student;
import com.example.bootactiviti7.activemq.produce.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName ProviderController.java
 * @Description TODO
 * @createTime 2021年08月23日 10:18:00
 */
@RestController
public class ProviderController {
    @Autowired
    private QueueProducer queueProducer;
    //注入存放消息的队列，用于下列方法一

    @GetMapping("/value")
    public String value() {
        //自定义队列名称
        String queueName="QUEUE_RECEIVE_ADD_FRIEND";
        Student student = new Student();
        student.setName("小明");
        student.setAge(11);
        //发送到MQS
        queueProducer.sendObjectMessage(queueName, student);
        return "消息已经发送";
    }

}
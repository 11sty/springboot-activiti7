package com.example.bootactiviti7.activemq.consumer;

import com.example.bootactiviti7.activemq.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName QueueAddFriendReceiver.java
 * @Description TODO
 * @createTime 2021年08月23日 10:14:00
 */
@Component
public class QueueAddFriendReceiver {
    private static final Logger log = LoggerFactory.getLogger(QueueAddFriendReceiver.class);

    /**
     * 红色为监听的队列名称
     */
    @JmsListener(destination = "QUEUE_RECEIVE_ADD_FIREND", containerFactory = "MyjmsQueueListener")
    public void receiveAddFriend(Student student) {
        System.out.println("啦啦啦啦"+student.toString());
        log.error("{}", "receiveAddFriend Exception:{}");


    }
}
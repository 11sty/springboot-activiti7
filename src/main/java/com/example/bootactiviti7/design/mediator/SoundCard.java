package com.example.bootactiviti7.design.mediator;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName SoundCard.java
 * @Description TODO
 * @createTime 2021年07月01日 10:51:00
 */
public class SoundCard extends Colleague {
    // 构造函数
    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    // 按照声频数据发出声音
    public void soundData(String data) {
        System.out.println("画外音：" + data);
    }
}

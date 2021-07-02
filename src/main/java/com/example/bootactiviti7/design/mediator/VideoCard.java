package com.example.bootactiviti7.design.mediator;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName VideoCard.java
 * @Description TODO
 * @createTime 2021年07月01日 10:51:00
 */
public class VideoCard extends Colleague {
    // 构造函数
    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    // 显示视频数据
    public void showData(String data) {
        System.out.println("您正在观看的是：" + data);
    }
}

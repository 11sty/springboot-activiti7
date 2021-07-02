package com.example.bootactiviti7.design.mediator;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Client.java
 * @Description 客户端类
 * @createTime 2021年07月01日 10:52:00
 */
public class Client {
    public static void main(String[] args) {
        // 创建调停者——主板
        MainBoard mediator = new MainBoard();
        // 创建同事类
        CDDriver cd = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard vc = new VideoCard(mediator);
        SoundCard sc = new SoundCard(mediator);
        // 让调停者知道所有同事
        mediator.setCdDriver(cd);
        mediator.setCpu(cpu);
        mediator.setVideoCard(vc);
        mediator.setSoundCard(sc);
        // 开始看电影，把光盘放入光驱，光驱开始读盘
        cd.readCD();
    }
}
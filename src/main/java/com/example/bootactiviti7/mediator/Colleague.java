package com.example.bootactiviti7.mediator;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Colleague.java
 * @Description TODO
 * @createTime 2021年07月01日 10:49:00
 */
public abstract class Colleague {
    // 持有一个调停者对象
    private Mediator mediator;
    // 构造函数
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    //获取当前同事类对应的调停者对象
    public Mediator getMediator() {
        return mediator;
    }
}
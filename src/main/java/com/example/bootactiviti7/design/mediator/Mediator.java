package com.example.bootactiviti7.design.mediator;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Mediator.java
 * @Description TODO
 * @createTime 2021年07月01日 10:52:00
 */
//@类说明 ：抽象调停者类
public interface Mediator {

    // 同事对象在自身改变的时候来通知调停者方法 让调停者去负责相应的与其他同事对象的交互
    public void changed(Colleague c);
}

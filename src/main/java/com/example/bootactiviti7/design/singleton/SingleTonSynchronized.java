package com.example.bootactiviti7.design.singleton;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName SingleTonSynchronized.java
 * @Description 线程同步，懒加载
 * @createTime 2021年07月02日 11:41:00
 */
public class SingleTonSynchronized {

    private static SingleTonSynchronized INSTANCE = null;

    private SingleTonSynchronized(){
    }

    public static SingleTonSynchronized getInstance(){
        if(INSTANCE == null){
            synchronized (SingleTonSynchronized.class){
                if(INSTANCE == null){
                    INSTANCE = new SingleTonSynchronized();
                }
            }
        }
        return INSTANCE;
    }
}

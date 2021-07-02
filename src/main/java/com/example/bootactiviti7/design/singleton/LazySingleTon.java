package com.example.bootactiviti7.design.singleton;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName LazySingleTon.java
 * @Description 多线程的不安全
 * @createTime 2021年07月02日 11:34:00
 */
public class LazySingleTon {
    /** 私有 */
    private static LazySingleTon INSTANCE = null;

    /** 私有 */
    private LazySingleTon() {
    }

    /** 唯一获取实例的方法 */
    public static LazySingleTon getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazySingleTon();
        }
        return INSTANCE;
    }
}

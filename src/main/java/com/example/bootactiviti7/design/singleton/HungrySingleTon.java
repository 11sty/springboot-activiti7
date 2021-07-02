package com.example.bootactiviti7.design.singleton;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName SingleTon.java
 * @Description 类加载时就完成了初始化，所以类加载比较慢，但获取对象的速度快
 * @createTime 2021年07月02日 11:33:00
 */
public class HungrySingleTon {
    /** 私有 */
    private static final HungrySingleTon INSTANCE = new HungrySingleTon();

    /** 私有 */
    private HungrySingleTon() {
    }

    /** 唯一获取实例的方法 */
    public static HungrySingleTon getInstance(){
        return INSTANCE;
    }
}

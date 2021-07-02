package com.example.bootactiviti7.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName PriceObserver.java
 * @Description TODO
 * @createTime 2021年07月01日 16:33:00
 */
public class HouseObserver implements Observer {
    /** 观察器名称 */
    private String name;

    public HouseObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        House house = (House) o;
        System.out.println(name + "检测到房子的价格从" + house.getPrice() + "变化到" + arg.toString());
    }
}

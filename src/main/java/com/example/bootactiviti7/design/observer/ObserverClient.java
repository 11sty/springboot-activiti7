package com.example.bootactiviti7.design.observer;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Cilent.java
 * @Description TODO
 * @createTime 2021年07月01日 16:37:00
 */
public class ObserverClient {

    public static void main(String[] args){
        House house = new House(100d);
        /** 定义观察者 */
        HouseObserver houseObserver1 = new HouseObserver("房子观察器1号");
        HouseObserver houseObserver2 = new HouseObserver("房子观察器2号");
        HouseObserver houseObserver3 = new HouseObserver("房子观察器3号");
        /** 添加观察者 */
        house.addObserver(houseObserver1);
        house.addObserver(houseObserver2);
        house.addObserver(houseObserver3);
        house.setPrice(500d);
        System.out.println("第二次变价");
        house.setPrice(500d);
    }
}

package com.example.bootactiviti7.design.observer;

import java.util.Observable;


/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName House.java
 * @Description TODO
 * @createTime 2021年07月01日 16:29:00
 */
public class House extends Observable {

    private Double price;

    public House(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (!price.equals(this.price)) {
            this.setChanged();
            this.notifyObservers(price);
        }
        this.price = price;
    }
}

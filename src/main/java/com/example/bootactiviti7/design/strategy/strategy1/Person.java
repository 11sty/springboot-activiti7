package com.example.bootactiviti7.design.strategy.strategy1;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2021年07月02日 14:19:00
 */
public class Person {

    /** 消费金额 */
    private Double price;

    public Person(Double price) {
        this.price = price;
    }

    /**
     * 当前用户打折
     * @return
     */
    public Double calcPrice(DiscountStrategy discountStrategy){
        return discountStrategy.calcPrice(this.price);
    }
}

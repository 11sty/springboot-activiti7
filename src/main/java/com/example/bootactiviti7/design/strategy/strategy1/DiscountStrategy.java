package com.example.bootactiviti7.design.strategy.strategy1;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName DiscountStrategy.java
 * @Description TODO
 * @createTime 2021年07月02日 14:11:00
 */
public interface DiscountStrategy {

    /**
     * 具体的打折办法
     * @param price
     * @return
     */
    public Double calcPrice(Double price);
}

package com.example.bootactiviti7.design.strategy.strategy1;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName AdvancedMemberStrategy.java
 * @Description TODO
 * @createTime 2021年07月02日 14:14:00
 */
public class AdvancedMemberStrategy implements DiscountStrategy{
    @Override
    public Double calcPrice(Double price) {
        System.out.println("高级会员，打五折");
        return price * 0.5;
    }
}

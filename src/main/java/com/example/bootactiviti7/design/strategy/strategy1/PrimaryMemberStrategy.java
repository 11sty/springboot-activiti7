package com.example.bootactiviti7.design.strategy.strategy1;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName PrimaryMemberStrategy.java
 * @Description TODO
 * @createTime 2021年07月02日 14:12:00
 */
public class PrimaryMemberStrategy implements DiscountStrategy{

    @Override
    public Double calcPrice(Double price) {
        System.out.println("初级会员，不打折");
        return price;
    }
}

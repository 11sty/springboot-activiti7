package com.example.bootactiviti7.design.strategy.strategy1;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName IntermediateMemberStrategy.java
 * @Description TODO
 * @createTime 2021年07月02日 14:13:00
 */
public class IntermediateMemberStrategy implements DiscountStrategy{
    @Override
    public Double calcPrice(Double price) {
        System.out.println("中级会员，打八折");
        return price * 0.8;
    }
}

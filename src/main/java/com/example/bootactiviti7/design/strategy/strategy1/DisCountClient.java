package com.example.bootactiviti7.design.strategy.strategy1;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName DisCount.java
 * @Description 实现用户消费后打折的三个算法
 * 　　算法一：对初级会员没有折扣。
 *
 * 　　算法二：对中级会员打八折。
 *
 * 　　算法三：对高级会员打五折。
 * @createTime 2021年07月02日 14:15:00
 */
public class DisCountClient {
    public static void main(String[] args){
        /** 先定义策略 */
        PrimaryMemberStrategy primaryMemberStrategy = new PrimaryMemberStrategy();
        IntermediateMemberStrategy intermediateMemberStrategy = new IntermediateMemberStrategy();
        AdvancedMemberStrategy advancedMemberStrategy = new AdvancedMemberStrategy();

        Person person = new Person(100d);
        Double discountPrice = 0d;
        discountPrice = person.calcPrice(primaryMemberStrategy);
        System.out.println("初级会员打折后价格" + discountPrice);
        discountPrice = person.calcPrice(intermediateMemberStrategy);
        System.out.println("中级会员打折后价格" + discountPrice);
        discountPrice = person.calcPrice(advancedMemberStrategy);
        System.out.println("高级会员打折后价格" + discountPrice);
    }
}

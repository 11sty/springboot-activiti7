package com.example.bootactiviti7.design.strategy.strategy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName StrategyCilent.java
 * @Description Comparable只是一个排序接口，实现了Comparable（排序接口）接口，就意味着该类支持排序
 * 存放该类的Collection或数组，可以直接通过Collection.sort()或着Arrays.sort进行排序
 * @createTime 2021年07月02日 15:50:00
 */
public class StrategyClient {

    public static void main(String[] args) {
        /**
         * 1、Cat实现比较接口，内部排序，直接调用集合·方法
        List<Cat> catList = new ArrayList<>();
        Cat cat1 = new Cat(1, 1);
        Cat cat2 = new Cat(3, 3);
        Cat cat3 = new Cat(2, 2);
        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        Collections.sort(catList);
        System.out.println(catList);
         */

        /**
         *2、用set传比较器排序
        Set<Dog> dogList = new TreeSet<>(new DogHeightComparator());
        Dog dog1 = new Dog(1, 1);
        Dog dog2 = new Dog(3, 3);
        Dog dog3 = new Dog(2, 2);
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        System.out.println(dogList);*/

        /** 3、策略模式 */
        Sorter<Dog> dogSorter = new Sorter<>();
        List<Dog> dogList = new ArrayList<>();
        Dog dog1 = new Dog(1, 1);
        Dog dog2 = new Dog(3, 3);
        Dog dog3 = new Dog(2, 2);
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogSorter.sort(dogList,new DogHeightComparator());
        System.out.println(dogList);
    }


}

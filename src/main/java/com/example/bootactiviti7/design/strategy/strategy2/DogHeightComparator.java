package com.example.bootactiviti7.design.strategy.strategy2;

import java.util.Comparator;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName CatHeightCompator.java
 * @Description TODO
 * @createTime 2021年07月02日 17:03:00
 */
public class DogHeightComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getHeight() - o2.getHeight();
    }
}

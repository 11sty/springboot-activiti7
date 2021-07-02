package com.example.bootactiviti7.design.strategy.strategy2;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Cat.java
 * @Description TODO
 * @createTime 2021年07月02日 14:39:00
 */
public class Cat implements Comparable<Cat> {
    /**
     * 高度
     */
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Cat(Integer height, Integer weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat o) {
        return this.getHeight() - o.getHeight();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

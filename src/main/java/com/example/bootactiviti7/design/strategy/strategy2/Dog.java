package com.example.bootactiviti7.design.strategy.strategy2;

import java.util.Objects;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Dog.java
 * @Description TODO
 * @createTime 2021年07月02日 14:41:00
 */
public class Dog {
    /**
     * 高度
     */
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

    public Dog(Integer height, Integer weight) {
        this.height = height;
        this.weight = weight;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return Objects.equals(height, dog.height) && Objects.equals(weight, dog.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

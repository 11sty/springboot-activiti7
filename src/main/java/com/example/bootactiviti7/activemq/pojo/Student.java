package com.example.bootactiviti7.activemq.pojo;

import java.io.Serializable;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2021年08月23日 10:16:00
 */
public class Student implements Serializable {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

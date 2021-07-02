package com.example.bootactiviti7.design.strategy.strategy2;

import java.util.Comparator;
import java.util.List;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Sorter.java
 * @Description TODO
 * @createTime 2021年07月02日 17:51:00
 */
public class Sorter<T> {
    public void sort(List<T> arr, Comparator<T> comparator) {
        int i, j = 0;
        T temp;
        for (i = 0; i < arr.size(); i++) {
            for (j = 1; j < arr.size() - i; j++) {
                //如果前面的元素大于后面的，则交换位置
                if (comparator.compare(arr.get(j - 1), arr.get(j)) > 0) {
                    temp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, temp);
                }
            }
        }
    }
}

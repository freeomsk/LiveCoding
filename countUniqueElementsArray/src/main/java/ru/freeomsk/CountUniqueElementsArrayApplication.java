package ru.freeomsk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountUniqueElementsArrayApplication {
    public static void main(String[] args) {

        int[] arr = new int[] { 9, 0, 8, 0, 1, 2, 4, 4, 5, 7, 8, 4, 3, 9, 2, 1, 7, 4, 6, 4, 1, 2};

        CountUniqueElementsArray(arr);
        CountUniqueElementsArrayWithoutFilter(arr);
        CountUniqueElementsArrayWithFilter(arr);
    }
    // 1 вариант (вывод в 2 колонки с табуляцией)
    public static void CountUniqueElementsArray(int[] arr) {
        int[] counter = new int[10];

        for (int j : arr) {
            counter[j]++;
        }

        System.out.println("value\tcount");
        for (int i = 0; i < counter.length; i++) {
            System.out.println(i + "\t" + counter[i]);
        }
    }

    // 2 вариант (без фильтра)
    public static void CountUniqueElementsArrayWithoutFilter(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(x -> map.merge(x, 1, Integer::sum));
        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }

    // 3 вариант (с фильтром)
    public static void CountUniqueElementsArrayWithFilter(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(x -> map.merge(x, 1, Integer::sum));
        map.entrySet().stream().filter(x -> x.getValue() > 0)
                .forEach(x -> System.out.println(x.getKey() + "=" + x.getValue()));
    }
}
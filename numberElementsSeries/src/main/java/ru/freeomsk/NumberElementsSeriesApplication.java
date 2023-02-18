package ru.freeomsk;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberElementsSeriesApplication {

    static int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int[] arr = {3, 2, 9, 4, 4, 1, 2, 5, 7, 3, 1, 5, 2};

    public static void main(String[] args) {
        System.out.println("Количество повторений элементов массива");
        System.out.println(findDuplicates(arr));
        findMaxDuplicates(arr);
        findMinDuplicates(arr);
        findNotExistElement(arr);
    }

    public static Map<Integer, Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer k : arr) {
            map.merge(k, 1, Integer::sum);
        }
        return map;
    }

    public static void findMaxDuplicates(int[] arr) {
        System.out.println("Самый часто встречающийся элемент массива");
        Map<Integer, Integer> map = findDuplicates(arr);

        Integer max_count = map.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(null);

        map.entrySet().stream()
                .filter(k -> Objects.equals(k.getValue(), max_count))
                .forEachOrdered(System.out::println);
    }

    public static void findMinDuplicates(int[] arr) {
        System.out.println("Самый редко встречающийся элемент массива");
        Map<Integer, Integer> map = findDuplicates(arr);

        Integer min_count = map.values()
                .stream()
                .min(Integer::compareTo)
                .orElse(null);

        map.entrySet().stream()
                .filter(k -> Objects.equals(k.getValue(), min_count))
                .forEachOrdered(System.out::println);
    }

    public static void findNotExistElement(int[] arr) {
        System.out.println("Числа от 1 до 10, не попавшие в массив");
        Set<Integer> set1 = IntStream.of(nums).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = IntStream.of(arr).boxed().collect(Collectors.toSet());
        set1.removeAll(set2);
        System.out.println(set1);
    }
}
package ru.freeomsk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllUniqueElementsArrayApplication {

    static int[] arr = {3, 2, 9, 4, 4, 1, 2, 5, 7, 3, 1, 5, 2};  // 7, 9
    public static void main(String[] args) {
        allUniqueElementsArray(arr);
    }

    public static void allUniqueElementsArray(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(array)
                .forEach(x -> map.merge(x,1, Integer::sum)); // {1=2, 2=3, 3=2, 4=2, 5=2, 7=1, 9=1}

        List<Integer> unique = map.entrySet().stream()
                .filter(x -> x.getValue() < 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(unique);
    }
}
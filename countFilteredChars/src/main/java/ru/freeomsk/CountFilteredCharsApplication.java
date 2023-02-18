package ru.freeomsk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFilteredCharsApplication {
    public static void main(String[] args) {
        List<Character> filter1to3 = Arrays.asList('1', '2', '3');

        System.out.println(countChars("5", filter1to3)); // пусто
        System.out.println(countChars("3", filter1to3)); // 3=1
        System.out.println(countChars("79165", filter1to3)); // 1=1
        System.out.println(countChars("91395139129", filter1to3)); // 1=3,2=1,3=2
    }

    public static String countChars(String str, List<Character> filter) {
        return str.chars().mapToObj(i -> (char) i)
                .filter(i -> Collections.frequency(filter, i) > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().map(k -> k.getKey() + "=" + k.getValue()).collect(Collectors.joining(","));
    }
}
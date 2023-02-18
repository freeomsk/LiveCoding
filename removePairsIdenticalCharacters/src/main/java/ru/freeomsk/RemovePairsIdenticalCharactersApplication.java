package ru.freeomsk;

import java.util.stream.Collectors;

public class RemovePairsIdenticalCharactersApplication {
    public static void main(String[] args) {
        String str = "cccabbaddd";

        System.out.println(removeCharactersCloser(str));
        System.out.println(removeCharactersCloser2(str));
    }

    // 1 вариант
    public static String removeCharactersCloser(String str) {
        return str.chars().mapToObj(x -> (char)x)
                .collect(Collectors.toMap(x -> x, y -> 1, Integer::sum))
                .entrySet().stream().filter(e -> e.getValue() % 2 != 0).map(entry -> entry.getKey() + "")
                .collect(Collectors.joining(""));
    }

    // 2 вариант
    public static String removeCharactersCloser2(String str) {
        StringBuilder builder = new StringBuilder(str);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < builder.length() - 1; i++) {
                if (builder.charAt(i) == builder.charAt(i + 1)) {
                    builder.deleteCharAt(i);
                    builder.deleteCharAt(i);
                    flag = true;
                }
            }
        }
        return builder.toString();
    }
}
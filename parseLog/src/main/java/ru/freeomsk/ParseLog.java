package ru.freeomsk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;

public class ParseLog {
    public static void main(String[] args) {
        List<String> result = parseLog(asList("4 5 10", "4 2 25", "5 1 100", "6 6 75"), 2);
        checkResult(result, asList("4", "5"));

        result = parseLog(asList("10 25 210", "1 25 210", "10 5 10", "4 2 25", "10 5 50", "4 25 10", "5 8 850", "6 22 75", "6 6 74"), 3);
        checkResult(result, asList("5", "10", "25"));

        System.out.println("Tests successful");
    }

    public static void checkResult(List<String> result, List<String> expected) {
        if (!String.join("", result).equals(String.join("", expected))) {
            throw new RuntimeException("Expected: " + expected + ", but was: " + result);
        }
    }

    public static List<String> parseLog(List<String> logs, int threshold) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (String s : logs) {
            var split = s.split(" ");
            var user1 = Integer.parseInt(split[0]);
            var user2 = Integer.parseInt(split[1]);
            map.put(user1, map.getOrDefault(user1, 0) + 1);
            if (user1 != user2) {
                map.put(user2, map.getOrDefault(user2, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            var value = map.get(key);
            if (value >= threshold) {
                list.add(key.toString());
            }
        }
        return list;
    }
}
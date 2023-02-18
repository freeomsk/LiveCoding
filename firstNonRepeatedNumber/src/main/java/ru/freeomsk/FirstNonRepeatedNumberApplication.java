package ru.freeomsk;

import java.util.*;

public class FirstNonRepeatedNumberApplication {
    public static void main(String[] args) {

        int[] arr = {9, 4, 9, 6, 7, 4}; // 6
        System.out.println(FirstNonRepeatedNumber(arr));
        System.out.println(FirstNonRepeatedNumber2(arr));
        System.out.println(FirstNonRepeatedNumber3(arr));
        System.out.println(FirstNonRepeatedNumber4(arr));

    }
// 1 вариант

    public static int FirstNonRepeatedNumber(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : arr) {
            if (!countMap.containsKey(i)) {
                countMap.put(i, 1);
            } else {
                countMap.put(i, countMap.get(i) + 1);
            }
        }

        Optional<Map.Entry<Integer, Integer>> optionalEntry = countMap.entrySet().stream()
                .filter(e -> e.getValue() == 1).findFirst();

        return optionalEntry.isPresent() ? optionalEntry.get().getKey() : -1;

    }

// 2 вариант
    public static int FirstNonRepeatedNumber2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++)
                if (i != j && arr[i] == arr[j])
                    break;
            if (j == n)
                return arr[i];
        }
        return -1;
    }

// 3 вариант
    public static int FirstNonRepeatedNumber3(int[] arr) {
        Arrays.sort(arr);
        for (int j = 0; j < arr.length; j++) {
            if (j == 0) {
                if (arr[j] != arr[j + 1]) {
                    return arr[j];
                }
            } else if (j == arr.length - 1) {
                if (arr[j] != arr[j - 1]) {
                    return arr[j];
                }
            } else {
                if (arr[j] != arr[j + 1] && arr[j] != arr[j - 1]) {
                    return arr[j];
                }
            }
        }
        return -1;
    }

// 4 вариант
    public static int FirstNonRepeatedNumber4(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int j : arr) {
            map.merge(j, 1, Integer::sum);
        }
        return map.entrySet()
                .stream()
                .filter(n -> n.getValue().equals(1))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalStateException("Это исключение гораздо полезнее, чем NoSuchElementException"));
    }
}
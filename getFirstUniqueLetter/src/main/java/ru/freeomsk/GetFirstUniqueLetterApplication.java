package ru.freeomsk;

import java.util.HashMap;
import java.util.Map;

public class GetFirstUniqueLetterApplication {
    public static void main(String[] args) {
        String inputString = "a, b, c, a";
        String inputStringWithoutDelimiter = "abca";
        System.out.println(getFirstUniqueLetter(inputString));
        System.out.println(firstNonRepeatingCharBruteForceNaive(inputString));
        System.out.println(firstNonRepeatingCharBruteForce(inputString));
        System.out.println(firstNonRepeatingCharWithMap(inputString));
        System.out.println(firstNonRepeatingCharWithArray(inputStringWithoutDelimiter));
    }

    // 1 вариант - перебором через массив.
    public static Character getFirstUniqueLetter(String inputString) {
        if (null == inputString || inputString.isEmpty()) {
            return null;
        }
        char[] charArray = inputString.toCharArray();
        int count;
        for (int i = 0; i < charArray.length; i++) {
            count = 0;
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[i] == charArray[j] && i != j) {
                    count++;
                }
            }
            if (count == 0) {
                return charArray[i];
            }
        }
        return null;
    }

    // 2 вариант - перебором без массива.
    public static Character firstNonRepeatingCharBruteForceNaive(String inputString) {
        if (null == inputString || inputString.isEmpty()) {
            return null;
        }
        for (int outer = 0; outer < inputString.length(); outer++) {
            boolean repeat = false;
            for (int inner = 0; inner < inputString.length(); inner++) {
                if (inner != outer && inputString.charAt(outer) == inputString.charAt(inner)) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                return inputString.charAt(outer);
            }
        }
        return null;
    }

    // 3 вариант - более компактное решение 2 варианта.
    public static Character firstNonRepeatingCharBruteForce(String inputString) {
        if (null == inputString || inputString.isEmpty()) {
            return null;
        }
        for (Character c : inputString.toCharArray()) {
            int indexOfC = inputString.indexOf(c);
            if (indexOfC == inputString.lastIndexOf(c)) {
                return c;
            }
        }
        return null;
    }

    // 4 вариант - оптимизированный через Map.
    public static Character firstNonRepeatingCharWithMap(String inputString) {
        if (null == inputString || inputString.isEmpty()) {
            return null;
        }
        Map<Character, Integer> frequency = new HashMap<>();
        for (int outer = 0; outer < inputString.length(); outer++) {
            char character = inputString.charAt(outer);
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }
        for (Character c : inputString.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    // 5 вариант - при ограничении входной строки.
    public static Character firstNonRepeatingCharWithArray(String inputStringWithoutDelimiter) {
        if (null == inputStringWithoutDelimiter || inputStringWithoutDelimiter.isEmpty()) {
            return null;
        }
        int[] frequency = new int[26];
        for (int outer = 0; outer < inputStringWithoutDelimiter.length(); outer++) {
            char character = inputStringWithoutDelimiter.charAt(outer);
            frequency[character - 'a']++;
        }
        for (Character c : inputStringWithoutDelimiter.toCharArray()) {
            if (frequency[c - 'a'] == 1) {
                return c;
            }
        }
        return null;
    }
}
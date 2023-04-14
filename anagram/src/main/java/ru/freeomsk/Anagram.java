package ru.freeomsk;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagram {
    public static void main(String[] args) {

        String s1 = "qwerty";
        String s2 = "eqyrwt";

        System.out.println(isAnagramSort(s1, s2));
        System.out.println(isAnagramSortMinimum(s1, s2));
        System.out.println(isAnagramCounting(s1, s2));
        System.out.println(isAnagramMultiset(s1, s2));
        System.out.println(isLetterBasedAnagramMultiset(s1, s2));
        System.out.println(checkAnagram(s1, s2));
    }

    //     1 вариант - проверка с помощью сортировки
    public static boolean isAnagramSort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    // 2 вариант - проверка с помощью сортировки в одну строчку кода
    public static boolean isAnagramSortMinimum(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());
    }

    // 3 вариант - проверка путем подсчета
    public static boolean isAnagramCounting(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int characterRange = 256;
        int[] count = new int[characterRange];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < characterRange; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 4 вариант - проверка с помощью MultiSet
    public static boolean isAnagramMultiset(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        Multiset<Character> multiset1 = HashMultiset.create();
        Multiset<Character> multiset2 = HashMultiset.create();
        for (int i = 0; i < string1.length(); i++) {
            multiset1.add(string1.charAt(i));
            multiset2.add(string2.charAt(i));
        }
        return multiset1.equals(multiset2);
    }

    // 5 вариант - через Map

    private static boolean checkAnagram(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (Character c : s1.toCharArray()){
            map1.merge(c, 1, Integer::sum);
        }
        for (Character c : s2.toCharArray()){
            map2.merge(c, 1, Integer::sum);
        }
        for(Character c : map1.keySet()) {
            if (!Objects.equals(map1.get(c), map2.get(c)))
                return false;
        }
        return s1.length() == s2.length();
    }
// 6 вариант - анаграмма на основе букв.
// Приведенные до сих пор примеры не соответствуют строго лингвистическому определению анаграммы.
// Это потому, что они считают знаки препинания частью анаграммы, и они чувствительны к регистру.
// Адаптируем алгоритмы, чтобы включить анаграмму на основе букв.
// Рассмотрим только перестановку букв без учета регистра, независимо от других символов, таких как пробелы и знаки препинания.
// Например, "A decimal point" и “I’m a dot in place.” были бы анаграммами друг друга.
// Чтобы решить эту проблему, можно сначала предварительно обработать две входные строки,
// чтобы отфильтровать нежелательные символы и преобразовать буквы в строчные буквы.
// Затем можно использовать одно из приведенных выше решений
// (например, решение с несколькими наборами) для проверки анаграмм в обработанных строках.

    public static String preprocess(String source) {
        return source.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    public static boolean isLetterBasedAnagramMultiset(String s1, String s2) {
        return isAnagramMultiset(preprocess(s1), preprocess(s2));
    }
}
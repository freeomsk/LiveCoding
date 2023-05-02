package ru.freeomsk;

public class DeduplicateSymbol {
    public static void main(String[] args) {
        String input = "Зздрррраавствввууй,    Ссссбееерррр!";
        String expected = "Здравствуй, Сбер!";

        if (deduplicateSymbol(input).equals(expected)) {
            System.out.println("Test success");
        } else {
            System.out.println("Test failure");
        }

        if (deduplicateSymbol2(input).equals(expected)) {
            System.out.println("Test success");
        } else {
            System.out.println("Test failure");
        }
    }

    // 1 вариант
    public static String deduplicateSymbol(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        char el = chars[0];
        sb.append(el);
        for (int i = 1; i < chars.length; i++) {
            if (Character.toLowerCase(chars[i]) != Character.toLowerCase(el)) {
                sb.append(chars[i]);
            }
            el = chars[i];
        }
        return sb.toString();
    }

    // 2 вариант
    static String deduplicateSymbol2(String input) {
        StringBuilder sb = new StringBuilder();
        String[] strings = input.split("");
        sb.append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if (!strings[i].equalsIgnoreCase(strings[i - 1])) {
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }
}
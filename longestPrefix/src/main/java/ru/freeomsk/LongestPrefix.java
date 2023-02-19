package ru.freeomsk;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] strings = {"flow", "flower", "flight"};
        System.out.println(longestPrefix(strings));
    }

    public static String longestPrefix(String[] str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str[0].length(); i++) {

            for (int j = 1; j < str.length; j++) {
                if (str[0].charAt(i) == (str[j].charAt(i))) {
                    if (j == str.length - 1) {
                        stringBuilder.append(str[j].charAt(i));
                    }

                } else {
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}
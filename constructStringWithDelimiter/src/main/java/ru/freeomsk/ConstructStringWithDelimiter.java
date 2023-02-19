package ru.freeomsk;

public class ConstructStringWithDelimiter {
    public static void main(String[] args) {
        String[] array = new String[]{"One", "Two", "Three"};
        String delimiter = "---";

        System.out.println(constructStringWithDelimiter(array, delimiter));
    }

    public static String constructStringWithDelimiter(String[] array, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != array.length; i++) {
            sb.append(array[i]).append(delimiter);
        }
        return sb.substring(0, sb.length() - delimiter.length());
    }
}
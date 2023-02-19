package ru.freeomsk;

public class CompressStringNumberOfLetters {
    public static void main(String[] args) {
        String str = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";

        System.out.println(rle(str));
        System.out.println(rle2(str));
    }

    // 1 вариант
    public static String rle(String str) {
        if (!str.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException();
        }
        StringBuilder builder = new StringBuilder();
        Character lastChar = null;
        int lastCharCounter = 1;
        for (char ch : str.toCharArray()) {
            if (lastChar == null) {
                lastChar = ch;
            } else if (lastChar.equals(ch)) {
                lastCharCounter++;
            } else {
                builder.append(lastChar);
                if (lastCharCounter > 1) {
                    builder.append(lastCharCounter);
                }
                lastChar = ch;
                lastCharCounter = 1;
            }
        }
        builder.append(lastChar).append(lastCharCounter);
        return builder.toString();
    }

    // 2 вариант
    public static String rle2(String str) {
        if (!str.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException();
        }
        StringBuilder res = new StringBuilder();
        int counter = 0;
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == prev) {
                counter++;
            } else {
                res.append(str.charAt(i - 1));
                if (counter != 0) {
                    res.append(counter + 1);
                }
                counter = 0;
                prev = c;
            }
        }
        res.append(str.charAt(str.length() - 1));
        if (counter != 0) {
            res.append(counter + 1);
        }
        return res.toString();
    }
}
package ru.freeomsk;

public class ReverseStringUpperCaseApplication {
    public static void main(String[] args) {
        String str = "Иванов Иван Иванович";
        System.out.println(transformationString(str));

    }
    public static String transformationString(String str){
        StringBuilder sb = new StringBuilder(str.toLowerCase()).reverse();
        String s1 = String.valueOf(sb);
        StringBuilder s2 = new StringBuilder();
        s2.append(s1.substring(0, 1).toUpperCase());
        for (int i = 1; i < s1.length(); i++) {
            if(" ".equals((s1.substring(i - 1, i)))) s2.append(s1.substring(i, i + 1).toUpperCase());
            else s2.append(s1.charAt(i));
        }
        return s2.toString();
    }
}
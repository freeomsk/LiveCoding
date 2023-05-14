package ru.freeomsk;

public class FindTheLongestBalancedSubstring {
    public static void main(String[] args) {
        System.out.println(findMaxSubstrLength("00100011101")); // 10
        System.out.println(findMaxSubstrLength("11010111")); // 4
        System.out.println(findMaxSubstrLength("111")); // 0
    }

    public static int findMaxSubstrLength(String input) {
        // Инициализируем переменную, хранящую максимальную длину подстроки
        int maxLength = 0;

        // Проходим по строке, используя i как начальный индекс
        for (int i = 0; i < input.length() - maxLength; i++) {
            // Инициализируем переменные, хранящие количество нулей и единиц
            int zeroes = 0, ones = 0;

            // Проходим по строке, начиная с текущего индекса i
            for (int j = i; j < input.length(); j++) {
                // Если текущий символ - ноль, увеличиваем счетчик нулей, иначе - счетчик единиц
                if (input.charAt(j) == '0') {
                    zeroes++;
                } else {
                    ones++;
                }

                // Если количество нулей и единиц равно и первый символ в подстроке - ноль, то...
                if (zeroes == ones && input.charAt(i) == '0') {
                    // Вычисляем длину текущей подстроки
                    int length = j - i + 1;

                    // Если длина подстроки больше максимальной, то обновляем максимальную длину
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }

        // Возвращаем максимальную длину
        return maxLength;
    }
}
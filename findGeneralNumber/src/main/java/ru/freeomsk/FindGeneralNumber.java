package ru.freeomsk;

public class FindGeneralNumber {
    public static void main(String[] args) {
        System.out.println(findGeneralNumber(
                new int[]{1, 2, 4, 5},
                new int[]{3, 3, 4},
                new int[]{2, 3, 4, 5, 6}
        )); // ответ: 4
    }

    private static Integer findGeneralNumber(int[] arr1, int[] arr2, int[] arr3) {
        int p1 = 0, p2 = 0, p3 = 0; // доп.память O(1)

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            // в худшем случае O(p+q+r)
            // в лучшем случае O(min(p,q,r))
            if (arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3]) {
                return arr1[p1];
            }
            try {
                if (arr1[p1] < arr2[p2] || arr1[p1] < arr3[p3]) {
                    p1++;
                }
                if (arr2[p2] < arr1[p1] || arr2[p2] < arr3[p3]) {
                    p2++;
                }
                if (arr3[p3] < arr1[p1] || arr3[p3] < arr2[p2]) {
                    p3++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return null;
            }
        }
        return null;
    }
}
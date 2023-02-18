package ru.freeomsk;

public class ElementsDoNotOccurApplication {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 7};
        int[] arr2 = {2, 3, 4, 6, 8};

        // 1 вариант
        for (int k : arr1) {
            boolean temp = false;
            for (int i : arr2) {
                if (k == i) {
                    temp = true;
                    break;
                }
            }
            if (!temp) {
                System.out.println(k);
            }
        }

// 2 вариант - O(n)
        int k = 0;
        int l = 0;

        while (k < arr1.length) {
            if (arr1[k] != arr2[l]) {
                System.out.println(arr1[k]);
            } else l++;
            k++;
        }
    }
}

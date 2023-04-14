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

// 3 вариант
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else { // arr1[i] == arr2[j]
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            System.out.println(arr1[i]);
            i++;
        }
    }
}

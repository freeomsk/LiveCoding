package ru.freeomsk;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ElementsDoNotOccurApplication {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 7};
        int[] arr2 = {2, 3, 4, 6, 8};

        getElementsNotInSecondArray3(arr1, arr2);
        System.out.println("---------");

        getElementsNotInSecondArray4(arr1, arr2);
        System.out.println("---------");

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

        System.out.println("---------"); // для разделения вариантов 1 и 2

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
//    3 вариант
    public static void getElementsNotInSecondArray3(int[] arr1, int[] arr2){
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        Arrays.stream(arr1).filter(e -> !set2.contains(e)).forEach(System.out::println);
    }

//    4 вариант - O(n)
    public static void getElementsNotInSecondArray4(int[] arr1, int[] arr2) {
        // Инициализируем указатели на начало массивов
        int i = 0, j = 0;

        // Проходим по массивам с помощью указателей
        while (i < arr1.length && j < arr2.length) {
            // Если текущий элемент в arr1 меньше текущего элемента в arr2, добавляем его в результат
            if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i]);
                i++;
                // Если текущий элемент в arr1 больше текущего элемента в arr2, переходим к следующему элементу в arr2
            } else if (arr1[i] > arr2[j]) {
                j++;
                // Если текущие элементы в arr1 и arr2 равны, переходим к следующим элементам в обоих массивах
            } else {
                i++;
                j++;
            }
        }
        // Если в arr2 остались элементы, пропускаем их
        while (i < arr1.length) {
            System.out.println(arr1[i]);
            i++;
        }
    }
}
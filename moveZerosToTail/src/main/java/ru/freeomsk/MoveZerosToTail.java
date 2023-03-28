package ru.freeomsk;

import java.util.Arrays;

public class MoveZerosToTail {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(zeroToTail(new int[] {1, 0, 2}))); // 1, 2, 0
        System.out.println(Arrays.toString(zeroToTail(new int[] {1, 2, 0, 3, 4, 0, 5, 6, 7, 0, 0, 8, 9}))); // 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0

    }

    private static int[] zeroToTail(int[] arr) {
        int count = 0; // для подсчета количества нулей в массиве
        int i = 0; // обрабатываемая позиция в массиве
        while (i + count < arr.length) { // пока не кончился массив
            if (arr[i + count] == 0) {
                count++; // перескакиваем 0
            } else {
                arr[i] = arr[i + count]; // пишем не 0
                i++;
            }
        }
        while (count > 0) { // дописываем 0
            arr[arr.length - count--] = 0;
        }
        return arr;
    }
}
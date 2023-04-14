package ru.freeomsk;

public class FindIndexOfElementArray {
    public static void main(String[] args) {
        int[] sortedArr = {1, 3, 6, 9, 12};
        System.out.println(findIndex(sortedArr, 3)); // 1
    }

    // Бинарный поиск
    public static int findIndex(int[] sortedArr, int target) {
        int left = 0;
        int rigth = sortedArr.length - 1;

        while (left <= rigth) {
            int mid = left + (rigth - left) / 2;

            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] < target) {
                left = mid + 1;
            } else {
                rigth = mid - 1;
            }
        }

        return -1;
    }
}
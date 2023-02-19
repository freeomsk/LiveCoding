package ru.freeomsk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindOfMissingElements {
    public static void main(String[] args) {

        int[] arr = {9, 6, 4, 5, 7, 0, 1};
        int n = 3;

        System.out.println(Arrays.toString(findOfMissingElements(arr, n)));
    }

    public static int[] findOfMissingElements(int[] arr, int n) {
        int[] result = new int[n];
        int j = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        for(int i = 1; i < arr.length + n; i++) {
            if(!set.contains(i)) {
                result[j] += i;
                j++;
            }
        }
        return result;
    }
}
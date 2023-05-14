package ru.freeomsk;

public class Theater {
    public static void main(String[] args) {
        System.out.println("2 = " + findSeat(new int[]{1, 0, 0, 0, 1}));
        System.out.println("должно быть 4, но " + findSeat(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}));
        System.out.println("должно быть 3, но " + findSeat(new int[]{1, 0, 0, 0, 0, 1}));
        System.out.println("должно быть 3, но " + findSeat(new int[]{0, 0, 0, 1, 0, 0, 0, 0, 1}));
    }

    private static int findSeat(int[] arr) {
        int count = 0; // длина обрабатываемого участка ряда
        int max = 0; // максимальная длина участка ряда
        boolean edge = true; // участок ряда находится на краю ряда

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) { // свободный участок ряда начался/продолжается
                count++;
                if (count > max) { // при каждом нахождении свободного места
                    max = count;   // если текущий участок длиннее предыдущего
                    // крайность определяется только для самого длинного
                    edge = j == 0 || j == arr.length - 1;
                }
            } else { // свободный участок ряда закончился
                count = 0;
            }
        }

        if (edge) { // для крайних берем всю длину
            return max;
        } else { // для средних участков вычисляем середину между зрителями
            return max / 2 + (max % 2 == 0 ? 0 : 1);
        }
//          return max / (edge ? 1 : 2) + (max % 2 == 0 || edge ? 0 : 1);
    }
}
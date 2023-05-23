/*
В этом примере мы создаем функцию findMaxConsecutiveOnes, которая принимает массив целых чисел.
Функция ищет максимальную длину интервала из единиц при условии, что можно удалить или пропустить не более одного нуля из исходной строки.
В функции main мы вызываем функцию findMaxConsecutiveOnes с примером массива и выводим результат на экран.
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
//        int[] array = {1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}; // 6
        int[] array = {1, 0, 1, 1, 1, 0, 1, 1 }; // 5

        int maxLength = findMaxConsecutiveOnes(array);
        System.out.println("Максимальная длина интервала из единиц: " + maxLength);
    }

    public static int findMaxConsecutiveOnes(int[] array) {
        int left = 0;
        int right = 0;
        int maxOnes = 0;
        int zeroCount = 0;

        while (right < array.length) {
            if (array[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (array[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left);
            right++;
        }

        return maxOnes;
    }
}
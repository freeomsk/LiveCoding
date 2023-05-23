import java.util.Arrays;

public class ArrayNeighborhoodSize {
    public static void main (String[] args) {
        int[] array = {2, 1, 5, 3, 2};
        int[] result = arrayNeighborhoodSize(array);
        System.out.println(Arrays.toString(result));
    }

    private static int[] arrayNeighborhoodSize(int[] array) {
        // если значения исходного массива нельзя изменять, то создаём новый массив
        int[] result = new int[array.length];
        int p1 = 0;
        int count = 1;

        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 == 0) {
                if (j == 0 || array[j - 1] % 2 != 0) {
                    while (p1 < j) {
                        result[p1++] = count;
                    }
                    count = 1;
                } else {
                    count++;
                }
            } else {
                if (j == 0 || array[j - 1] % 2 == 0) {
                    while (p1 < j) {
                        result[p1++] = count;
                    }
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        while (p1 < array.length) {
            result[p1++] = count;
        }

        return result;
    }
}

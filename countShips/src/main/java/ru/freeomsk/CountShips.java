package ru.freeomsk;

import java.util.stream.IntStream;

public class CountShips {
    public static void main(String[] args) {
        int[][] board = {
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(countShips(board));
        System.out.println(countShips2(board));
    }

//    1 вариант
    public static int countShips(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if ((i > 0 && board[i - 1][j] == 1) || (j > 0 && board[i][j - 1] == 1)) {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

//    2 вариант
    public static int countShips2(int[][] matrix) {
        return IntStream.range(0, matrix.length)
                .flatMap(i -> IntStream.range(0, matrix[0].length)
                        .filter(j -> matrix[i][j] == 1 && (i == 0 || matrix[i-1][j] == 0) && (j == 0 || matrix[i][j-1] == 0))
                        .map(j -> 1))
                .sum();
    }
}
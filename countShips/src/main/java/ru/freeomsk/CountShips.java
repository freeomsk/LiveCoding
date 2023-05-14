package ru.freeomsk;

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
    }

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
}
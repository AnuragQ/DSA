package java.recursion;

import java.io.*;

public class NQueens {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        printNQueens(chess, "", 0);
        System.out.println();
    }
    

    public static void printNQueens(boolean[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            if (isQueenSafe(chess, row, i) ) {
                chess[row][i] = true;
                printNQueens(chess, qsf + row + "-" + i + ", ", row + 1);
                chess[row][i] = false;
            }
            // return false;
        }


    }
    public static boolean isQueenSafe(boolean[][] chess, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][col]) {
                return false;
            }
        }
        for (int i = row - 1,  j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j]) {
                return false;
            }
        }
        for (int i = row - 1,  j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j]) {
                return false;
            }
        }
        return true;




    }
}
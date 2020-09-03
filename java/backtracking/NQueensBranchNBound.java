import java.io.*;
import java.util.*;

public class NQueensBranchNBound {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // boolean[][] board = new boolean[n][n];
        //write your code here
        boolean[] cols = new boolean[n];
        boolean[] normalDiagonals = new boolean[2 * n - 1]; //row+col
        boolean[] reverseDiagonals = new boolean[2 * n - 1]; // row-col + n-1

        // row,n,cols,nd,rd,psf
        NQueens(0, n, cols, normalDiagonals, reverseDiagonals, "");
        scn.close();
    }
    public static void NQueens(int row, int n, boolean[] cols, boolean[] normalDiagonals, boolean[] reverseDiagonals, String psf) {
        if (row == n) {
            System.out.println(psf + '.');
        }
// System.out.println(row);
        for (int i = 0; i < n; i++) {
            
            if (cols[i] || normalDiagonals[row + i] || reverseDiagonals[row - i + n - 1]) {
                continue;
            } else {
                cols[i] = true;
                normalDiagonals[row + i] = true;
                reverseDiagonals[row - i + n - 1] = true;
                NQueens(row+1, n, cols, normalDiagonals, reverseDiagonals, psf+row+"-"+i+", ");
                cols[i] = false;
                normalDiagonals[row + i] = false;
                reverseDiagonals[row - i + n - 1] = false;
            }



        }
    }
    
    
}

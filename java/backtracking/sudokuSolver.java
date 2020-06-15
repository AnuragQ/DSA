

/*package whatever //do not write package name here */

import java.io.*;

class sudokuSolver {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[][] board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(row[j]);
                }
            }
            solve(board);
            display(board);

        }


    }

    private static void solve(int[][] board) {
        
    }

    public static void display(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
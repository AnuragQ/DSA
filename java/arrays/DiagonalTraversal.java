package java.arrays;

import java.util.*;

public class DiagonalTraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int m = sc.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
                // System.out.println(array[i][j]);
            }
        }
        sc.close();
        printDiagonalTraversal(array);



    }
public static void printDiagonalTraversal(int[][] array){
    int n=array.length;
    for(int i=0;i<n;i++){

        for(int col=i,  row=0;row<n & col<n;row++,col++){
            System.out.println(array[row][col]);
        }
    }
}

}
package java.arrays;

import java.util.*;

public class SpiralDisplay {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] array=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
                // System.out.println(array[i][j]);
            }
        }

        

    }
static void spiralDisplay(int[][] array,int m,int n ){
    int rows = 0;
    int rowe = n - 1;
    int cols = 0;
    int cole = m - 1;
    int i = 0;
    while (rowe >= rows & cole >= cols) {
        // while(counter<=m*n){
        // System.out.println("==="+rows+"==="+rowe);

        for (i = rows; i <= rowe & cole >= cols; i++) {
            System.out.println(array[i][cols]);

        }
        cols++;
        // System.out.println("==="+cols+"==="+cole);
        for (i = cols; i <= cole & rows <= rowe; i++) {
            System.out.println(array[rowe][i]);

        }
        rowe--;
        // System.out.println("==="+rowe+"==="+rows);

        for (i = rowe; i >= rows & cole >= cols; i--) {
            System.out.println(array[i][cole]);

        }
        cole--;
        // System.out.println("==="+cole+"==="+cols);

        for (i = cole; i >= cols & rows <= rowe; i--) {
            System.out.println(array[rows][i]);

        }
        rows++;
        
    }
    
}
}
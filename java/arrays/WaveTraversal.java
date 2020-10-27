package java.arrays;

import java.util.*;

public class WaveTraversal {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    int[][] array=new int[n][m];
    for (int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            array[i][j]=sc.nextInt();
            // System.out.println(array[i][j]);
        }

    }
        waweTraversal(array, m, n);
    sc.close();
    
    
    
 }
static void waweTraversal(int[][] array,int m,int n){
    for (int j=0;j<m;j++){
        for(int i=0;i<n;i++){
            int row=j%2==0?i:n-i-1;
            // array[row][j]=sc.nextInt();
            System.out.println(array[row][j]);
        }
    }
}

}
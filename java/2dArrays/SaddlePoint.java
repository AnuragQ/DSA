// 1. You are given a number n, representing the number of rows and columns of a square matrix.
// 2. You are given n * n numbers, representing elements of 2d array a.
// 3. You are required to find the saddle point of the matrix which is defined as the value which is smallest in it's row but largest in it's column.
// Note - There can be only 1 saddle point or none. Think why?

import java.io.*;

public class SaddlePoint {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }
        int[] minArr=new int[n];
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                min=Math.min(min,arr[i][j]);
            }
            minArr[i]=min;
        }
        int[] maxArr=new int[n];
        for(int i=0;i<n;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                max=Math.max(max,arr[j][i]);
            }
            maxArr[i]=max;
        }
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(minArr[i]==maxArr[j]){
                    found=true;
                    
                    
                    System.out.print(minArr[i]);
                }
            }
        }
        if(!found){
            System.out.print("Invalid input");
        }
    }

}
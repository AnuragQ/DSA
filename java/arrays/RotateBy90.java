package arrays;

import java.util.*;


public class RotateBy90 {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int m=sc.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
                // System.out.println(array[i][j]);
            }
        }
        sc.close();
        rotateBy90(array);
        display(array);

    }
static void rotateBy90(int[][] array){
    int n=array.length;
    for (int i = 0; i < n / 2; i++) {

        for (int j = i; j < n - i - 1; j++) {
            int temp = array[i][j];
            array[i][j] = array[n - j - 1][i];
            array[n - j - 1][i] = array[n - i - 1][n - j - 1];
            array[n - i - 1][n - j - 1] = array[j][n - i - 1];
            array[j][n - i - 1] = temp;

        }
    }
}

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}


// PEP solution
// public static void rotateby90(int[][] arr){
//     // transpose
//     for(int i = 0; i < arr.length; i++){
//        for(int j = 0; j < i; j++){
//           int temp = arr[i][j];
//           arr[i][j]= arr[j][i];
//           arr[j][i] = temp;
//        }
//     }
//     // reverse columns, row by row
//     for(int i = 0; i < arr.length; i++){
//        int li = 0;
//        int ri = arr[0].length - 1;
//        while(li <= ri){
//           int temp = arr[i][li];
//           arr[i][li] = arr[i][ri];
//           arr[i][ri] = temp;

//           li++;
//           ri--;
//        }
//     }
//  }
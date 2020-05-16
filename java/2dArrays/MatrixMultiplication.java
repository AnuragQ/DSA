import java.util.*;

public class MatrixMultiplication {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] array1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                array1[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        int[][] array2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                array2[i][j] = sc.nextInt();
            }
        }
        if (n2 != m1) {
            System.out.print("Invalid input");
        } else {
            int[][] prod = new int[n1][m2];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    int sum = 0;
                    for (int k = 0; k < n2; k++) {
                        sum += array1[i][k] * array2[k][j];

                    }
                    prod[i][j] = sum;
                }
            }
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    System.out.print(prod[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
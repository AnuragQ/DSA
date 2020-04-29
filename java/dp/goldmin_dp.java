package java.dp;

// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
// 4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
// 5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
// 6. Each cell has a value that is the amount of gold available in the cell.
// 7. You are required to identify the maximum amount of gold that can be dug out from the mine.
import java.io.*;

public class goldmin_dp {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, getCost(arr, i, n - 1, 0, m - 1, new int[n][m]));
        }
        System.out.print(ans);


    }

    public static int getCost(int[][] arr, int rs, int rd, int cs, int cd, int[][] strg) {
        if (cs == cd) {
            return arr[rs][cs];
        }
        int ans = Integer.MIN_VALUE;
        if(strg[rs][cs]!=0){
            return strg[rs][cs];
        }
        ans = Math.max(ans, getCost(arr, rs, rd, cs + 1, cd, strg));
        if (rs - 1 >= 0) {
            ans = Math.max(ans, getCost(arr, rs - 1, rd, cs + 1, cd, strg));
            // get(arr,rs-1,rd,cs+1,cd,strg);
        }
        if (rs + 1 <= rd) {
            ans = Math.max(ans, getCost(arr, rs + 1, rd, cs + 1, cd, strg));

        }
        strg[rs][cs]=arr[rs][cs] + ans;
        return arr[rs][cs] + ans;

    }

}
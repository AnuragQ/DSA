
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {

    /* package whatever //do not write package name here */

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            // 1-d array
            int n = Integer.parseInt((br.readLine()));
            String[] inp = br.readLine().split(" ");
            int[] arr = new int[inp.length];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            System.out.println(arr.length);
            

            // 2-d array
            // int m = Integer.parseInt((br.readLine()));
            // int n = Integer.parseInt((br.readLine()));
            // int[][] arr = new int[m][n];
            // for(int i=0;i<m;i++){
            //     for (int j = 0; j < n; j++) {
            //         String[] inp = br.readLine().split(" ");
            //         arr[i][j] = Integer.parseInt(inp[j]);
            //     }
            // }

            //n inputs
            //String[] inp = br.readLine().split(" ");
            //int k=Integer.parseInt(inp[0]);
            //int l=Integer.parseInt(inp[1]);
            //int m=Integer.parseInt(inp[2]);

        }

        br.close();

    }
}

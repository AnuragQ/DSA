import java.io.*;
import java.util.*;

public class paint_house_many_colors {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  l = br.readLine();
        int n = Integer.parseInt(l.split(" ")[0]);

        int m =Integer.parseInt( l.split(" ")[1]);

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] items = str.split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(items[j]);
                
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i=0;i<m;i++){
        ans = Math.min(ans, arr[0][i] + paintcost(arr, 1, i, new int[n][m], m));
        }
        System.out.print(ans);

    }
    public static int paintcost(int[][] arr, int idx, int prev, int[][] strg, int cols) {
        if (idx == arr.length) {
            return 0;
        }
        if (strg[idx][prev] != 0) {
            return strg[idx][prev];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            if (i == prev) {
                continue;
            }
            ans = Math.min(ans, arr[idx][i] + paintcost(arr, idx + 1, i, strg, cols));
        }

        strg[idx][prev] = ans;
        return ans;
    }
}
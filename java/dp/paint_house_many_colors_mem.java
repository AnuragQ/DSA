package java.dp;

import java.io.*;

public class paint_house_many_colors_mem {

    public static void main(final String[] args) throws Exception {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String  l = br.readLine();
        final int n = Integer.parseInt(l.split(" ")[0]);

        final int m =Integer.parseInt( l.split(" ")[1]);

        final int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            final String str = br.readLine();
            final String[] items = str.split(" ");
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
    public static int paintcost(final int[][] arr, final int idx, final int prev, final int[][] strg, final int cols) {
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
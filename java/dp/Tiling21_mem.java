import java.io.*;

public class Tiling21_mem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(tileCount(n, new int[n + 1]));
    }

    public static int tileCount(int n, int[] strg) {
        if (n <= 1) {
            return 1;
        }
        if (strg[n] != 0) {
            return strg[n];
        }
        int ans1 = tileCount(n - 1, strg);
        int ans2 = 0;
        if (n >= 2) {

            ans2 = tileCount(n - 2, strg);
        }
        // System.out.println(n+" "+ans1+" "+ans2);
        strg[n] = ans1 + ans2;
        return ans1 + ans2;
    }
}
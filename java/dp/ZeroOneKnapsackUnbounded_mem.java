import java.io.*;

public class ZeroOneKnapsackUnbounded_mem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());
        System.out.print(getCC(wts, values, 0, cap, new int[n][cap + 1]));
    }

    public static int getCC(int[] wts, int[] vals, int idx, int cap, int[][] strg) {

        if (idx == wts.length - 1) {
            return 0;
        }
        if (strg[idx][cap] != 0) {
            return strg[idx][cap];
        }
        int amount = cap;
        int ans = Integer.MIN_VALUE;

        ans = Math.max(ans, getCC(wts, vals, idx + 1, cap, strg));
        int value = vals[idx];
        while (amount - wts[idx] >= 0) {
            if (wts[idx] == 0) {
                continue;
            }
            ans = Math.max(ans, value + getCC(wts, vals, idx + 1, amount - wts[idx], strg));
            value += vals[idx];
            amount -= wts[idx];
        }
        strg[idx][cap] = ans;
        return ans;

    }
}

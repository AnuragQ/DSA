import java.io.*;
import java.util.*;

public class RussianDollEnvelops_iter {
    public static class Envelope implements Comparable < Envelope > {
        int w;
        int h;

        public int compareTo(Envelope e) {
            return this.w - e.w;
        }

    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Envelope[] envlps = new Envelope[n];
        for (int i = 0; i < envlps.length; i++) {
            String str = br.readLine();
            envlps[i] = new Envelope();
            envlps[i].w = Integer.parseInt(str.split(" ")[0]);
            envlps[i].h = Integer.parseInt(str.split(" ")[1]);
        }
        Arrays.sort(envlps);
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envlps[j].h < envlps[i].h) {
                    if (dp[j] > dp[i]) {
                        dp[i] = dp[j];
                    }
                }

            }
            dp[i] += 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.print(ans);


        //   System.out.print(envlps);
    }

}
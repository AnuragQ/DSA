import java.io.*;

public class CoinChangePermutations_iter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int amt = Integer.parseInt(br.readLine());

        int[] dp = new int[amt + 1];
        dp[0] = 1;
        for (int j = 1; j <= amt; j++) {
            for (int i = 0; i < n; i++) {

                int amount = j;
                amount -= arr[i];
                if (amount < 0) {
                    continue;
                }
                if (dp[amount] != 0) {
                    dp[j] += dp[amount];
                }
            }

        }

        System.out.print(dp[amt]);

    }
}
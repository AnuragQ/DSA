import java.io.*;

public class LIS_mem {
public static int[] dp;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp=new int[n];
        System.out.print(bitonic(arr, 0, -1, dp));
    }

    public static int bitonic(int[] arr, int idx, int li,int[] dp) {
        if (arr.length == idx) {
            return 0;
        }
        // if(dp[idx]!=0){
        //     return dp[idx];
        // }
        int rv = Integer.MIN_VALUE;
        rv = Math.max(rv, bitonic(arr, idx + 1, li, dp));
        
            if (li < 0 || arr[idx] > arr[li]) {
                rv = Math.max(rv, bitonic(arr, idx + 1, idx, dp) + 1);

            }
            dp[idx]=rv;
        return rv;

    }
}
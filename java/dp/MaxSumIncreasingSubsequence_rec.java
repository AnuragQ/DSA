import java.io.*;

public class MaxSumIncreasingSubsequence_rec {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(maxSum(arr, 0, -1));
    }

    public static int maxSum(int[] arr, int idx, int li) {
        if (arr.length == idx) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        // int ans2=Integer.MIN_VALUE;
        ans=Math.max(ans,maxSum(arr, idx + 1, li));
        
            if (li < 0 || arr[idx] >=arr[li]) {
                ans= Math.max(ans,maxSum(arr, idx + 1, idx)+arr[idx]);

            }
        return ans;

    }
}
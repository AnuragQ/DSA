import java.io.*;

public class CountBinaryStrings_iter {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // getCount(n);
        int[] dp=new int[n+3];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+3;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n+2]);
    }


}
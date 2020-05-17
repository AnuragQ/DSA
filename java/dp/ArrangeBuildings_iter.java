import java.io.*;

public class ArrangeBuildings_iter{

public static void main(String[] args) throws Exception {
    // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // getCount(n);
        long[] dp=new long[n+3];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+3;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n+2]*dp[n+2]);
    }


}
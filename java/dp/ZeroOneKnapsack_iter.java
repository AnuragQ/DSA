import java.io.*;

public class ZeroOneKnapsack_iter {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
            String[] valsString=br.readLine().split(" ");
        String[] wtsString=br.readLine().split(" ");

        int[] wts=new int[n+1];
        int[] vals=new int[n+1];

        for(int i=0;i<n;i++){
            wts[i+1]=Integer.parseInt(wtsString[i]);
            vals[i+1]=Integer.parseInt(valsString[i]);

        }
        int cap=Integer.parseInt(br.readLine());
        // System.out.println(n+" "+cap);
        int[][] dp=new int[n+1][cap+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=cap;j++){
                int include=0;
                if(wts[i]<=j){
                     include=dp[i-1][j-wts[i]]+(vals[i]);
                }
                int exclude=dp[i-1][j];
        // System.out.println(include+" "+exclude);
                dp[i][j]=Math.max(include,exclude);
            }
        }
        System.out.println(dp[n][cap]);
        
        
    }
}
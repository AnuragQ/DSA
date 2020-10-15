import java.io.*;

public class UnboundedKnapsack_iter {

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
        int[] dp=new int[cap+1];
        
        for(int i=1;i<=cap;i++){
            int wt=0;
            for(int j=1;j<=n;j++){
                if(wts[j]<=i){
                    wt=Math.max(wt,dp[i-wts[j]]+vals[j]);
                }
            }
            dp[i]=wt;
            
        }
        System.out.println(dp[cap]);

        
        // int[][] dp=new int[n+1][cap+1];

        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=cap;j++){
        //         int include=0;
        //         if(wts[i]<=j){
        //             //  include=Math.max(dp[i-1][j-wts[i]],dp[i][j-wts[i]])+(vals[i]);
        //                 include=dp[i][j-wts[i]]+(vals[i]);

        //         }
        //         int exclude=dp[i-1][j];
        //         dp[i][j]=Math.max(include,exclude);
        //     }
        // }
        // System.out.println(dp[n][cap]);
    
    
    }
}
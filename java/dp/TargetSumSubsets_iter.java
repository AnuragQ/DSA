import java.util.*;

public class TargetSumSubsets_iter {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        int[] arr= new int[n+1];
        for(int i=0;i<n;i++){
            arr[i+1]=sc.nextInt();
        }
        int target=sc.nextInt();
        
        
        sc.close();
        
        boolean[][] dp=new boolean[n+1][target+1];
        
        
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=target;j++){
                boolean include=false;
                if(arr[i]<=j){
                    include=dp[i-1][j-arr[i]];   
                }
                boolean exclude=dp[i-1][j];
                dp[i][j]=exclude||include;
            }
        }
        System.out.println(dp[n][target]);
    }
}
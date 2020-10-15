import java.io.*;
import java.util.*;

public class PrintAllPathsWithTargetSumSubset {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here
        boolean[][] dp=new boolean[n+1][tar+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            dp[i][0]=true;
            int val=arr[i-1];
            for(int j=1;j<=tar;j++){
                if(j-val>=0){
                    dp[i][j]|=dp[i-1][j-val];
                }
                dp[i][j]|=dp[i-1][j];
            }
        }
        
        
        
        System.out.println(dp[n][tar]);
        
        ArrayDeque<Pair> q=new ArrayDeque<>();
        
        q.add(new Pair(n,tar,""));
        
        while(q.size()>0){
            Pair rem=q.remove();
            if( rem.j==0){
                System.out.println(rem.psf);
                continue;
            }
            
            
            if(rem.j-arr[rem.i-1]>=0 && dp[rem.i-1][rem.j-arr[rem.i-1]]==true){
                q.add(new Pair(rem.i-1,rem.j-arr[rem.i-1],(rem.i-1)+" "+rem.psf));
            }
            if(dp[rem.i-1][rem.j]==true){
                q.add(new Pair(rem.i-1,rem.j,rem.psf));
            }
        }
        
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=tar;j++){
        //         System.out.print(dp[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        

    }
}


                        


                        
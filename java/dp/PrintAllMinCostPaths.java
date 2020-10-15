import java.io.*;
import java.util.*;

public class PrintAllMinCostPaths {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
      int[][] dp=new int[n][m];
      
      for(int i=n-1;i>=0;i--){
          for(int j=m-1;j>=0;j--){
              if(i==n-1 && j==m-1){
                  dp[i][j]=arr[i][j];
              }else if(i==n-1){
                  dp[i][j]=arr[i][j]+dp[i][j+1];
              }else if(j==m-1){
                  dp[i][j]=arr[i][j]+dp[i+1][j];
              }else{
                  dp[i][j]=arr[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
              }
              
              
              
              //My Approach
            //   int h=Integer.MAX_VALUE;
            //   int v=Integer.MAX_VALUE;
            //   if(i+1<arr.length){
            //       v=dp[i+1][j];
            //   }
            //   if(j+1<arr[i].length){
            //       h=dp[i][j+1];
            //   }
            //   if(i==n-1 && j==m-1){
            //       h=0;v=0;
            //   }
            //   dp[i][j]=arr[i][j]+Math.min(h,v);

          }
      }
      System.out.println(dp[0][0]);
      
      ArrayDeque<Pair> q=new ArrayDeque<>();
      q.add(new Pair("",0,0));
      while(!q.isEmpty()){
          Pair rem=q.remove();
          int i=rem.i;
          int j=rem.j;
          if(i==n-1 && j==m-1){
              System.out.println(rem.psf);
              continue;
          }else if(i==n-1){
              q.add(new Pair(rem.psf+"H",i,j+1));
          }else if(j==m-1){
              q.add(new Pair(rem.psf+"V",i+1,j));
          }else{
              if(dp[i+1][j]>dp[i][j+1]){
                  q.add(new Pair(rem.psf+"H",i,j+1));

              }else if(dp[i+1][j]<dp[i][j+1]){
                  q.add(new Pair(rem.psf+"V",i+1,j));

              }else{
                q.add(new Pair(rem.psf+"V",i+1,j));
                q.add(new Pair(rem.psf+"H",i,j+1));
 
              }
          }
          
          
          
          
      }
      
      
   }

}









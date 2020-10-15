import java.io.*;
import java.util.*;

public class PrintAllPathsWithMaxGold {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair( int i, int j,String psf) {
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
      int omax=0;
      
      int[][] dp=new int[n][m];
      for(int j=m-1;j>=0;j--){
          for(int i=0;i<n;i++){
              if(j==m-1){
                  dp[i][j]=arr[i][j];
              }else{
                  int max=dp[i][j+1];
                  if(i-1>=0){
                      max=Math.max(max,dp[i-1][j+1]);
                  }
                  
                  if(i+1<n){
                      max=Math.max(max,dp[i+1][j+1]);
                  }
                  dp[i][j]=max+arr[i][j];
              }
              if(j==0){
                  omax=Math.max(omax,dp[i][j]);
              }
          }
      }
      
      System.out.println(omax);
      ArrayDeque<Pair> q=new ArrayDeque<>();
      for(int i=0;i<n;i++){

          if(dp[i][0]==omax){
              q.add(new Pair(i,0,i+" "));
          }
      }
      
      while(q.size()>0){
          Pair rem=q.remove();

          if(rem.j==m-1){
            System.out.println(rem.psf);
              continue;
          }

          if(rem.i-1>=0){

              if(dp[rem.i-1][rem.j+1]==dp[rem.i][rem.j]-arr[rem.i][rem.j]){
                  q.add(new Pair(rem.i-1,rem.j+1,rem.psf+"d1 "));
              }
              
          }
          if(dp[rem.i][rem.j+1]==dp[rem.i][rem.j]-arr[rem.i][rem.j]){
              
              q.add(new Pair(rem.i,rem.j+1,rem.psf+"d2 "));
          }
          if(rem.i+1<n){
              if(dp[rem.i+1][rem.j+1]==dp[rem.i][rem.j]-arr[rem.i][rem.j]){
                  q.add(new Pair(rem.i+1,rem.j+1,rem.psf+"d3 "));
              }
          }
      }
      
      
   }


}














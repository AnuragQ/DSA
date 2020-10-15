import java.util.ArrayDeque;
import java.util.Scanner;

public class PrintAllPathsWithMinJumpsClimbStairs{
    public static class Pair{
        int i;
        int jump;
        String psf;
        public Pair(int i,int jump,String psf){
            this.i=i;
            this.jump=jump;
            this.psf=psf;
        }
    }
    public static void Solution(int arr[]){
        // write your code here
        int n=arr.length;
        Integer[] dp=new Integer[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            // System.out.println(dp[i+1]+"--"+(i+1));
            if(arr[i]==0){
                continue;
            }
            Integer min=Integer.MAX_VALUE;
            for(int j=i+1;j<=Math.min(arr[i]+i,arr.length-1);j++){
                if(dp[j]!=null){
                    min=Math.min(dp[j],min);
                }
            }
            if(min==Integer.MAX_VALUE){
                dp[i]=null;
            }else{
                dp[i]=min+1;
            }
            
        }
        System.out.println(dp[0]);
        
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(0,dp[0],"0"));
        while(q.size()>0){
            Pair rem=q.remove();

            if(rem.jump==0){
                System.out.println(rem.psf+" .");
                continue;
            }
            for(int i=1;i<=arr[rem.i] && i+rem.i<arr.length;i++){
                if(dp[rem.i+i]!=null && dp[rem.i+i]==rem.jump-1){
                    q.add(new Pair(rem.i+i,dp[rem.i+i],rem.psf+" -> "+(rem.i+i)));
                }
            }
        }
        
        
        
        
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}

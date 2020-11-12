
import java.util.*;


import java.lang.*;
import java.io.*;

public class Solution_2 {
    

    /* package whatever //do not write package name here */
    
    
    public static int[] one_d(BufferedReader br) throws IOException{
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        return arr;
    }   
    // static class P{
    //     int i;
    //     int j;
    //     int val;
    //     P(int i,int j,int val){
    //         this.i=i;
    //         this.j=j;
    //         this.val=val;
    //     }
    // }
    public static String solution(BufferedReader br) throws IOException{
        int ans=0;
        int[] params=one_d(br);
        int n=params[0];
        int k=params[1];
        int p=params[2];
        int[][] arr=new int[n][k];
        for(int i=0;i<n;i++){
            arr[i]=one_d(br);
        }
        ans=getMax(arr,0,p,k,new int[n+1][p+1]);


        // for(int i=0;i<n;i++){
        //     pq.add(new P(i,0,arr[i][0]));
        // }
        // for(int i=0;i<p;i++){
        //     P rem=pq.remove();
        //     ans+=rem.val;
        //     if(rem.j<k-1){
        //         pq.add(new P(rem.i,rem.j+1,arr[rem.i][rem.j+1]));
        //     }
        // }
        
        
        return ""+ans;
    }

    private static int getMax(int[][] arr, int j, int p, int k,int[][] strg) {
        
        if(j>=arr.length){
            return 0;
        }
        if(strg[j][p]!=0){
            return strg[j][p];
        }
        int ans=getMax(arr, j+1, p, k,strg);
        int cumSum=0;
        for(int i=0;i<k && i<p;i++){
            cumSum+=arr[j][i];
            ans=Math.max(ans,cumSum+getMax(arr, j+1, p-i-1, k,strg));
        }
        strg[j][p]=ans;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            count++;            
            String ans=solution(br);
            System.out.println("Case #"+count+": "+ans);

        }
        

        br.close();

    }
}

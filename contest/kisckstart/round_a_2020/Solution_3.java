
import java.util.*;


import java.lang.*;
import java.io.*;

public class Solution_3 {
    

    /* package whatever //do not write package name here */
    
    
    public static int[] one_d(BufferedReader br) throws IOException{
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        return arr;
    }   

    public static String solution(BufferedReader br) throws IOException{
        int[] params=one_d(br);
        int k=params[1];
        
        int[] arr=one_d(br);
        int lo=1;
        int hi=1000000000;
        int mid=0;
        int[] diff=new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            diff[i]=arr[i+1]-arr[i];
        }
        int ans=-1;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(isValid(diff,mid,k)){
                hi=mid-1;
                ans=mid;
            }else{
                lo=mid+1;
            }
        }
        return ""+ans;
    }
    // public static String solution(BufferedReader br) throws IOException{
    //     int[] params=one_d(br);
    //     int k=params[1];
    //     int[] arr=one_d(br);
    //     PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
    //     for(int i=1;i<arr.length;i++){
    //         int diff=arr[i]-arr[i-1];
    //         if(diff>1){
    //             pq.add(diff);
    //         }
    //     }
    //     for(int i=0;i<k && pq.size()>0;i++){
    //         int rem=pq.remove();
    //         int rem1=(rem)/2;
    //         int rem2=rem-rem1;
    //         if(rem1>1){
    //             pq.add(rem1);
    //         }
    //         if(rem2>1){
    //             pq.add(rem2);
    //         }
    //     }
    //     return ""+(pq.size()==0?1:pq.peek());
    // }

    private static boolean isValid(int[] diff, int optd, int k) {
        
        for(int i=0;i<diff.length;i++){
            int reqd_k=((diff[i]-1)/optd);
            if(reqd_k>k){
                return false;
            }else{
                k-=reqd_k;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        // code
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

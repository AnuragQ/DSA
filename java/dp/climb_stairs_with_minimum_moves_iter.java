
/*
LINK-https://www.pepcoding.com/resources/placement-bootcamp---batch-1/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move. 
You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of staircase.
Note -> If there is no path through the staircase print null.
*/

import java.io.*;
import java.util.Scanner;

public class climb_stairs_with_minimum_moves_iter {

    public static void main(String[] args) throws IOException {



        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        
        Integer[] dp=new Integer[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
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
    }

   
}
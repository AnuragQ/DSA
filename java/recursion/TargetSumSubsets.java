// package java.recursion;

import java.io.*;

public class TargetSumSubsets {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
    
        for(int i = 0; i < n; i++){
           arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());
        printTargetSumSubsets(arr, 0, "", 0, tar);
    System.out.println();
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        
        if(tar==sos && idx==arr.length){
            System.out.println(set+".");
            return;
        }   
        if(tar<sos || idx==arr.length){
            return;
        }
        printTargetSumSubsets(arr,idx+1,set+String.valueOf(arr[idx] +", "),sos+arr[idx],tar);
        printTargetSumSubsets(arr,idx+1,set,sos,tar);
    }

}
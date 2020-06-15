package arrays;


// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
//package whatever //do not write package name here 

import java.util.*;
import java.io.*;

class ChocolateDistribution {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt((br.readLine()));
		    String[] inp=br.readLine().split(" ");
		    int[] arr=new int[inp.length];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		    }
		    
		    	int m=Integer.parseInt(br.readLine());
        		
        		Arrays.sort(arr);
        		int ans=Integer.MAX_VALUE;
        		for(int i=0;i<arr.length-m+1;i++){
        		    ans=Math.min(ans,arr[i+m-1]-arr[i]);
        		    
        		}
        		System.out.println(ans);
	
		}
		
		 br.close();

		
		
	}
}
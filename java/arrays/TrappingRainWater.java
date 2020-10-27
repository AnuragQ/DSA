/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    String[] inp=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		    }
		    int totalWater=trappingRainWater(arr);
		    
		    System.out.println(totalWater);
		    
		}
	}
static int trappingRainWater(int[] arr){
    int n=arr.length;
    int[] leftMaxHeight=new int[n];
    int leftmax=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        leftMaxHeight[i]=leftmax;
        leftmax=Math.max(arr[i],leftmax);
    }
    
    int totalWater=0;
    int rightmax=Integer.MIN_VALUE;
    for(int i=n-1;i>=0;i--){
        int height=Math.max(Math.min(rightmax,leftMaxHeight[i]),0);
        totalWater+=Math.max(height-arr[i],0);
        rightmax=Math.max(arr[i],rightmax);
    }
    return totalWater;
}
}
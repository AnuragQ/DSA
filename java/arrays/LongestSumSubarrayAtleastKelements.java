
/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k/0
// https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/
import java.util.*;
import java.lang.*;
import java.io.*;

class LongestSumSubarrayAtleastKelements {
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    String[]  inp=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		        
		    }
		    int k=Integer.parseInt(br.readLine());
		    int[] kadane=new int[n];
		    int prevSubSum=0;
		    for(int i=0;i<n;i++){
		        prevSubSum+=arr[i];
		        if(prevSubSum<arr[i]){
		            
		            prevSubSum=arr[i];
		        }
		        kadane[i]=prevSubSum;
		    }
		    int l=0;
		    int r=k;
		    int windowSum=0;
		    for(int i=l;i<r;i++){
		        windowSum+=arr[i];
		    }
		    int ans=windowSum;
		    while(r<arr.length){
		        windowSum+=(arr[r]-arr[l]);
		        
		        ans=Math.max(ans,windowSum+Math.max(0,kadane[l]));
		        l++;
		        r++;
		    }
		    System.out.println(ans);
            
		    
		}
	}
}






package arrays;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxLengthBitonicSubarray {
	public static void main(String[] args) throws IOException {
		// code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt((br.readLine()));
			String[] inp = br.readLine().split(" ");
			int[] arr = new int[inp.length];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inp[i]);
			}
            int ans=bitonic(arr,n);
            System.out.println(ans);
            
		}

		br.close();

    }
    // space O(1)-https://www.geeksforgeeks.org/maximum-length-bitonic-subarray-set-2-time-o1-space/
    // time O(N) space O(N)
    private static int bitonic(int[] arr,int n) {
        int[] ascending = new int[n];
            int[] descending = new int[n];
            int ctr=1;
            ascending[0]=1;
            for(int i=1;i<n;i++){
                
                if(arr[i]>arr[i-1]){
                    // ctr+=1
                    ascending[i]=++ctr;
                }else{
                    ctr=1;
                    ascending[i]=ctr;
                }
            }
            descending[n-1]=1;
            ctr=1;
            for(int i=n-2;i>=0;i--){
                if(arr[i+1]<arr[i]){
                    descending[i]=++ctr;
                }else{
                    ctr=1;
                    descending[i]=ctr;
                }
            }
            int ans=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                ans=Math.max(ans,ascending[i]+descending[i]-1);
                
            }
            return ans;
    }
}
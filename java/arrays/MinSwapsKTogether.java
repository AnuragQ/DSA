package arrays;

/*package whatever //do not write package name here */

// import java.util.*;
// import java.lang.*;
import java.io.*;

class MinSwapsKTogether {
	public static void main (String[] args) throws IOException{
		//code
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt((br.readLine()));
			String[] inp = br.readLine().split(" ");
			int[] arr = new int[inp.length];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inp[i]);
			}
			int k = Integer.parseInt((br.readLine()));
			int ans=minSwapsKTogether(arr, k);
			System.out.println(ans);
			

		}

		br.close();
		
	}
static int minSwapsKTogether(int[] arr,int k){
    int n=arr.length;
    int good=0;
    for (int i=0;i<n;i++){
        if(arr[i]<=k){
            good++;
        } 
    }
    int ans=0,bad=0;
    for(int i=0; i<good;i++){
        if(arr[i]>k){
            bad++;
        }
    }
    ans=bad;
    for(int i=0,j=good;j<arr.length;i++,j++){
        if(arr[i]>k){
            bad--;
        }
        if(arr[j]>k){
            bad++;
        }
        ans=Math.min(ans,bad);
    }
    return ans;
}
	
}
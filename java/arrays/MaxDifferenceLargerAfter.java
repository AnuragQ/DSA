package arrays;

/*package whatever //do not write package name here */

// import java.util.*;
// import java.lang.*;
import java.io.*;

class MaxDifferenceLargerAfter {
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

            int ans=maxDifferenceLargerAfter(arr);
            
            System.out.println(ans);
        
		}
		

		br.close();

	}
static int maxDifferenceLargerAfter(int[] arr){
    int n=arr.length;
    int max=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i]<max){
                ans=Math.max(ans,max-arr[i]);
            }else{
                max=arr[i];
            }
        }
        ans=Math.max(ans,-1);
        return ans;
}
}
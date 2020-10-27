package arrays;

/*package whatever //do not write package name here */

import java.io.*;

class MinMergesReqdForPalindrome {
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
			int count=minMergesReqdForPalindrome(arr);
			System.out.println(count);
			

		}

		br.close();

	}
static int minMergesReqdForPalindrome(int[] arr){
    int count=0;
    int n=arr.length;
    int i=0,j=n-1;
    while(i<=j){
        if(arr[i]==arr[j]){
            i++;
            j--;
            
        }else if(arr[i]>arr[j]){
            j--;
            arr[j]=arr[j]+arr[j+1];
            count++;
        }else if(arr[j]>arr[i]){
            i++;
            arr[i]=arr[i]+arr[i-1];
            count++;
        }
    }
    return count;
}
}
package arrays;

/*package whatever //do not write package name here */

// import java.util.*;
// import java.lang.*;
import java.io.*;

class SmallestNumberSubset {
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
            System.out.println(smallestNumberSubset(arr));

		}

		br.close();

    }

static int smallestNumberSubset(int[] arr){
    int n=arr.length;
    int max=1;
    boolean found=false;
    for (int i=0;i<n;i++){
        if(arr[i]>max){
            System.out.println(max);
            found=true;
            break;
        }else{
            max+=arr[i];
        }
    }
    
    return max;
}
}
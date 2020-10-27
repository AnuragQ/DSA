/*package whatever //do not write package name here */
// https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
// https://practice.geeksforgeeks.org/problems/maximum-index/0
import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumIndex {
	public static void main (String[] args) throws IOException {
	    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		  //  int num=Integer.parseInt(inp[1]);
		     String[]  inp=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		        
		    }
		    int ans=0;
		    
		    System.out.println(ans);
		    
		}
	}
static int maximumIndex(int[] arr){
    int n=arr.length;
    int[] max=new int[n];
        int msf=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            msf=Math.max(arr[i],msf);
            max[i]=msf;
        }
        int ans=0;
        for(int i=0;i<n-1;i++){
            int start=i;
            int end=n-1;
            int mid=(start+end)/2;
            int myans=0;
            while(start<=end){
                mid=(start+end)/2;
                if(max[mid]<arr[i]){
                    end=mid-1;
                }else{
                    start=mid+1;
                    myans=mid;
                }
                
                ans=Math.max(myans-i,ans);
            }
        }
    return ans;
}
}






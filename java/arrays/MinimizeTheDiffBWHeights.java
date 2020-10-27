/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/minimize-the-heights/0
// https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
import java.util.*;
import java.lang.*;
import java.io.*;

class MinimizeTheDiffBWHeights {
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int k=Integer.parseInt(br.readLine());

		    int n=Integer.parseInt(br.readLine());
		  //  int num=Integer.parseInt(inp[1]);
		    String[]  inp=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		        
			}
			System.out.println(minimizeTheDiffBWHeights(arr, k));
		    
		    
		    
		    
		}
	}
private static int minimizeTheDiffBWHeights(int[] arr, int k) {
    int n=arr.length;
    Arrays.sort(arr);
    int ans=arr[n-1]-arr[0];
    int big=arr[n-1]-k;
    int small=arr[0]+k;
    if(big<small){
        int temp=big;
        big=small;
        small=temp;
    }
    if((big-small)>=ans){
        return (ans);
    }else{
        for(int i=1;i<n-1;i++){
            if(arr[i]+k<=big || arr[i]-k>=small){
                continue;
            }else{
                if(arr[i]+k-big>small-arr[i]+k){
                    small=arr[i]-k;
                }else{
                    big=arr[i]+k;
                }
            }
        }
        return (big-small);
    }
}
}
package arrays;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Sort01 {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    String[] inp=br.readLine().split(" ");
		    int[] arr=new int[inp.length];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		    }
		    
		    for(int i=0;i<n;i++){
		        System.out.print(arr[i]+" ");
		    }
		    System.out.println();
	
		}
		
		 br.close();

		
		
	}
static void sort01(int[] arr){
    
    int n=arr.length,i=0,j=n-1;
    while(i<=j){
        while(i<n && arr[i]==0){
            i+=1;
        }
        while(j>=0 && arr[j]==1){
            j-=1;
        }
        if(i<j){
        arr[j]=1;
        arr[i]=0;}
    }
}
}
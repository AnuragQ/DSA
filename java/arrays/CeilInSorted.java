/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CeilInSorted {
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] inp=br.readLine().split(" ");
		    int n=Integer.parseInt(inp[0]);
		    int num=Integer.parseInt(inp[1]);
		    inp=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		        
		    }
		    
		    int ceil=n;
		    
		    int start=0;
		    int end=n-1;
		    int mid=(n-1)/2;
		    while(start<=end){
		        mid=(start+end)/2;
		        if(num<=arr[mid]){
		            end=mid-1;
		            ceil=mid;
		        }else if(num>arr[mid]){
		            
		            start=mid+1;
		        }
		    }
		    System.out.println(ceil);
		}
		
		
		br.close();
	}
}
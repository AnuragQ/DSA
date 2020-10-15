/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RearrangeAlternatePosNeg {
    public static void rotateRight(int[] arr,int start,int end){
        int temp=arr[end];
        for(int i=end;i>start;i--){
            arr[i]=arr[i-1];
        }
        arr[start]=temp;
    }
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    String[] inp=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		    }
		    
		    int index=0;
		    
		    while(index<n){
		        if(index%2==0 && arr[index]<0){
		            int nextPositive=index+1;
		            while(nextPositive<n && arr[nextPositive]<0){
		                nextPositive++;
		            }
		            if(nextPositive==n){
		                index++;
		                continue;
		            }
		            rotateRight(arr,index,nextPositive);
		        }
		        if(index%2==1 && arr[index]>=0){
		          int nextNegative=index+1;
		            while(nextNegative<n && arr[nextNegative]>=0){
		                nextNegative++;
		            }
		            if(nextNegative==n){
		                index++;
		                continue;
		            }
		            rotateRight(arr,index,nextNegative);
		        }
		        index++;
		    }
		    for(int i=0;i<n;i++){
		        System.out.print(arr[i]+" ");
		    }
		    System.out.println();
		    
		    
		    
		}
	}
}
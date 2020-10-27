            

    // https://practice.geeksforgeeks.org/problems/inversion-of-array/0        

    
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CountInversions_MergeSort {
    public static void main (String[] args) throws IOException{
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
            
            System.out.println(getInversions(arr,0,n-1));
          //  for(int i=0;i<arr.length;i++){
          //      System.out.print(arr[i]);
          //  }
            
        }
        
    }
    
public static long getInversions(int[] arr,int start,int end){
    if(end==start){
        return 0;
    }
    long ans=0;
    int mid=(start+end)/2;
    ans+=getInversions(arr,start,mid);
    ans+=getInversions(arr,mid+1,end);
    
    ans+=merge(arr,start,mid,end);
    return ans;
}
public static long merge(int[] arr,int start,int mid,int end){
    
    int[] left=new int[mid-start+1];
    int[] right=new int[end-mid];
    for(int i=start;i<=mid;i++){
        left[i-start]=arr[i];
    }
    for(int i=mid+1;i<=end;i++){
        right[i-mid-1]=arr[i];
    }
    
    long count=0;
    
    int leftPointer=0;
    int rightPointer=0;
    int idx=start;
    while(leftPointer<left.length && rightPointer<right.length){
        if(left[leftPointer]<=right[rightPointer]){
            arr[idx]=left[leftPointer];
            leftPointer++;
        }else{
            arr[idx]=right[rightPointer];
            rightPointer++;
            count+=left.length-leftPointer;

        }
        idx++;
    }
    
    
    while(leftPointer<left.length){
        arr[idx]=left[leftPointer];
        leftPointer++;
        idx++;
    }
    while(rightPointer<right.length){
        arr[idx]=right[rightPointer];
        rightPointer++;
        idx++;
    }
    return count;
}
    
}








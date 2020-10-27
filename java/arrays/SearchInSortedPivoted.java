/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SearchInSortedPivoted {
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
			int target=Integer.parseInt(br.readLine());

		    int index=searchInSortedPivoted(arr, target);
		    System.out.println(index);
		    
		    
		    
		  //  start=0;
		  // end=n-1;
		  //  int pivot=0;
		  //  while(start<end){
		      
		  //      mid=(start+end)/2;
		        
		  //      if(arr[mid]>arr[start] && arr[mid]>arr[end]){
		  //          if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
		  //              start=mid+1;
		  //          }else{
		  //              pivot=mid;
		  //              break;
		  //          }
		  //      }else if(arr[mid]<arr[end]  && arr[mid]<arr[start] ){
		  //          if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
		  //              end=mid-1;
		  //          }else{
		  //              pivot=mid;
		  //              break;
		  //          }
		  //      }
		  //  }
		       
		  //start=pivot;
		  //end=pivot-1;
		  //while(start!=end){
		  //    mid=(start+end)/2;
		  //}
		        
		        
		      
		    
		    
		}
	}

static int searchInSortedPivoted(int[] arr,int target){
    int n=arr.length;
    int start=0;
    int end=n-1;
    int mid=0; 
    int index=-1;
    while(start<=end){
        mid=(start+end)/2;
        if(arr[mid]==target){
            index=mid;
            break;
        }else
        // first array is sorted
        if(arr[mid]>=arr[start]){
            if(arr[mid]>=target && arr[start]<=target){
                end=mid-1;
            }else{
                start=mid+1;
            }
            
        }else
        //second array is sorted
        {
            if(target>arr[mid] && target<arr[end]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }	        
        
    }
    return index;
}
// 	public  static int binarySearch(int[] arr,int start,int end,int target){
// 	    int index=-1;
// 	    int mid=0;
// 	    while(start<=end){
// 	        mid=(start+end)/2;
// 	        if(arr[mid]<target){
// 	            start=mid+1;
// 	        }else if(arr[mid]>target){
// 	            end=mid-1;
	            
// 	        }else if(arr[mid]==target){
// 	            index=mid;
// 	            end=mid-1;
// 	        }
// 	    }
// 	    return index;
// 	}
}
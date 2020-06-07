package java.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class PairTargetDifference {
    public static void main(String[] args) throws IOException {
		//code

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] inp=br.readLine().split(" ");
		    int n=Integer.parseInt(inp[0]);
		    int target=Integer.parseInt(inp[1]);
		    String[] str=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(str[i]);
		    }
		  //  findPair_NLOGN_1(arr,target);
		 findPair_N_N(arr,target);   
		}
		
		
		
	}
	public static void findPair_NLOGN_1(int[] arr,int target){
	    Arrays.sort(arr);
    		int i=0,j=1;
    		boolean found=false;
    		while(i<arr.length && j<arr.length ){
    		    
    		    if(arr[j]-arr[i]==target){
    		        found=true;
    		        break;
    		    }else if(arr[j]-arr[i]<target){
    		        j++;
    		    }
    		    else{
    		        if(i<j-1){
    		            i++;
    		        }
    		        else{
    		            i++;
    		            j++;
    		        }
    		    }
    		}
    		System.out.println(found?1:-1);
	}
	public static void findPair_N_N(int[] arr,int target){
	    HashSet<Integer> hs = new HashSet<>();
    		
    		boolean found=false;
    		for (int i=0;i<arr.length;i++){
    		        hs.add(arr[i]+target);
    		    }
    		for (int i=0;i<arr.length;i++){
    		    if(hs.contains(arr[i])){
    		        found=true;
    		        break;
    		    }
    		}
    		System.out.println(found?1:-1);
	}
}
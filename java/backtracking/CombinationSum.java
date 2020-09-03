/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/combination-sum/0
import java.util.*;
import java.lang.*;
import java.io.*;

class CombinationSum {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int t=Integer.parseInt(br.readLine());//10
        while(t-->0){
            int n=Integer.parseInt(br.readLine());//10

            int[]arr=new int[n] ;
            
            String[] inp=br.readLine().split(" ");
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(inp[i]);
            } 
                        int tar=Integer.parseInt(br.readLine());//10
            Arrays.sort(arr);
            HashSet<Integer> hs=new HashSet<>();
            
            for(int i:arr){
                hs.add(i);
            }
            int[] newarr=new int[hs.size()];
            int idx=0;
            for(int i:hs){
                newarr[idx]=i;
                idx++;
            }
            empty=true;
            printSum(newarr,tar,"",0);
            if(empty){
                System.out.print("Empty");
            }
            System.out.println();
        }
	}
	public static boolean empty;
	public static void printSum(int[] arr,int tar,String asf,int idx){
	    if(tar==0){
	        empty=false;
	        System.out.print("("+asf.substring(0,asf.length()-1)+")");
	        return;
	    }
	    if(tar<0){
	        return;
	    }
	    for(int i=idx;i<arr.length;i++){
	        printSum(arr,tar-arr[i],asf+arr[i]+" ",i);
	    }
	}
}





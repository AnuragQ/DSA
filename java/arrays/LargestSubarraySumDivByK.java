package arrays;

/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

class LargestSubarraySumDivByK {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] inp=br.readLine().split(" ");
		    int n=Integer.parseInt(inp[0]);
		    int k=Integer.parseInt(inp[1]);
		    inp=br.readLine().split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		    }
		    HashMap<Integer,Integer> hm=new HashMap<>();
		    hm.put(0,-1);
		    int ans=0,sum=0;
		    for(int i=0;i<n;i++){
		        sum+=arr[i];
		        if(hm.containsKey(((sum%k)+k)%k)){
		            ans=Math.max(ans,i-hm.get(((sum%k)+k)%k));
		        }else{
		            hm.put(((sum%k)+k)%k,i);
		        }
		    }
		    System.out.println(ans);
		    
		    

		}
		br.close();
		
	}
}
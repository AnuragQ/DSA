/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class Pair implements Comparable<Pair>{
    int start;
    int end;
    @Override
    public int compareTo(Pair o){
        return this.start-o.start;
    }
    public Pair(int start, int end){
        this.start=start;
        this.end=end;
    }
    
}
class MergeIntervals {
    
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		  //  int num=Integer.parseInt(inp[1]);
		     String[]  inp=br.readLine().split(" ");
		    int[] arr=new int[n*2];
		    for(int i=0;i<n*2;i++){
		        arr[i]=Integer.parseInt(inp[i]);
		        
		    }
		    mergeIntervals(arr);
	    }
	}
static void mergeIntervals(int[] arr){
    int n=arr.length;
    Pair[] intervals=new Pair[n];
        int idx=0;
        for(int i=0;i<arr.length;i+=2){
            intervals[idx]=new Pair(arr[i],arr[i+1]);
            idx++;
        }
        Arrays.sort(intervals);
        
        int cstart=intervals[0].start;
        int cend=intervals[0].end;
        for(int i=1;i<n;i++){
            int nstart=intervals[i].start;
            int nend=intervals[i].end;
            if(nstart<=cend){
                cend=Math.max(nend,cend);
            }else{
                System.out.print(cstart+" "+cend+" ");
                cstart=nstart;
                cend=nend;
            }
        }
        System.out.println(cstart+" "+cend+" ");
}
}
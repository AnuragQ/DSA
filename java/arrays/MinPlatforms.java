/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class MinPlatforms {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    int[] arrivalTimes=new int[n];
		    int[] departureTimes=new int[n];
		    String[] arr=br.readLine().split(" ");
		    String[] dep=br.readLine().split(" ");
		  //  int[][] times=new int[n][2];
		    for(int i=0;i<n;i++){
		        arrivalTimes[i]=Integer.parseInt(arr[i]);
		        departureTimes[i]=Integer.parseInt(dep[i]);
		    }
	        minPlatforms(departureTimes, arrivalTimes);
		}
	}
static void minPlatforms(int[] departureTimes,int[] arrivalTimes){
    int n=departureTimes.length;
    Arrays.sort(arrivalTimes);
    Arrays.sort(departureTimes);

    int maxPlatforms=Integer.MIN_VALUE;
    int arrival=0;
    int departure=0;
    int platforms=0;
    while(arrival<n && departure<n){
        if( arrivalTimes[arrival]<=departureTimes[departure]){
            platforms++;
            arrival++;
        }else{
            platforms--;
            departure++;
        }
        maxPlatforms=platforms>=maxPlatforms?platforms:maxPlatforms;
    }
    System.out.println(maxPlatforms);
        
}
}
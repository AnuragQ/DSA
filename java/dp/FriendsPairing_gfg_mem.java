
// https://practice.geeksforgeeks.org/problems/friends-pairing-problem/0

// Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.


import java.util.*;

class FriendsPairing_gfg_mem{
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt();
		while (test>0){
		    test--;
		    int n=sc.nextInt();
		    System.out.println(getPair(n,new long[n+1]));
		}
        sc.close();
    }
	public static long getPair(int n,long[] dp){
	    if(n==1){
	        return 1;
	    }
	    if(n<=0){
	        return 1;
	    }
	    if(dp[n]!=0){
	        return dp[n];
	    }
	    long ans=getPair(n-2,dp)*(n-1);
        ans+=getPair(n-1,dp);
        dp[n]=ans%1000000007;
        return ans%1000000007;
    }
    
}
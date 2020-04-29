package java.dp;

// 1. You are given a number n, representing the count of coins.
// 2. You are given n numbers, representing the denominations of n coins.
// 3. You are given a number "amt".
// 4. You are required to calculate and print the number of combinations of the n coins using which the amount "amt" can be paid.
// Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be used for many installments in payment of "amt"
// Note2 -> You are required to find the count of combinations and not permutations i.e.
// 2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same combination. You should treat them as 1 and not 3.

import java.io.*;

public class coin_change_combination_dp {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int amt = Integer.parseInt(br.readLine());
        
        
        System.out.println(getCC(coins,0,amt,new int[n][amt+1]));

    }
    public static int getCC(int[] coins,int idx,int amt,int[][] strg){
        if(amt==0){
            return 1;
        }
        if(amt<0){
            return 0;
        }
        
        if(idx==coins.length-1){
            return 0;
        }
        if(strg[idx][amt]!=0){
            return strg[idx][amt] ;
        }
        int amount=amt;
        int ans=getCC(coins,idx+1,amt,strg);
        while(amt>0){
            if(coins[idx]==0){
                continue;
            }
            ans+=getCC(coins,idx+1,amt-coins[idx],strg);
            amt-=coins[idx];
        }
        strg[idx][amount]=ans;
        return ans;
        
    }
}
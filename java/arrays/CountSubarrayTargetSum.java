package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;
/*
2
11
2 3 -1 4 -5 1 6 -4 3 -1 4
4
6
1 2 3 -3 -2 -1
0
*/
public class CountSubarrayTargetSum {

    /* package whatever //do not write package name here */

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt((br.readLine()));
            String[] inp = br.readLine().split(" ");
            int[] arr = new int[inp.length];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int target=Integer.parseInt(br.readLine());

            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(0, 1);
            int cumulativeSum = 0;
            int count=0;
            for (int i = 0; i < n; i++) {
                cumulativeSum += arr[i];
                count+=hm.getOrDefault(cumulativeSum-target, 0);

                hm.put(cumulativeSum, hm.getOrDefault(cumulativeSum, 0) + 1);
                System.out.println(hm);
            }
            System.out.println(count);

        }

        br.close();

    }
}
// LEETCODE
// https://leetcode.com/problems/subarray-sum-equals-k/submissions/
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         HashMap<Integer,Integer> hm=new HashMap<>();
//         int sum=0, count=0;
//         hm.put(0,1);
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//             count+=hm.getOrDefault(sum-k,0);
//             hm.put(sum,hm.getOrDefault(sum,0)+1);           
//         }
//         return count;         
//     }
// }
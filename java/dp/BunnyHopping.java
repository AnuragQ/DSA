import java.util.*;

class BunnyHopping {
    public int solve(int[] nums, int k) {
        int[] dp=new int[nums.length];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        dp[nums.length-1]=nums[nums.length-1];
        map.put(dp[nums.length-1],1);
        for(int i=nums.length-2,j=1;i>=0;i--,j++){
            if(j<k){
                int min=map.firstKey();
                dp[i]=min+nums[i];
                map.put(dp[i],map.getOrDefault(dp[i],0)+1);
            }else{
                int min=map.firstKey();
                dp[i]=nums[i]+min;
                map.put(dp[i+k],map.get(dp[i+k])-1);
                if(map.get(dp[i+k])==0){
                    map.remove(dp[i+k]);
                }
                map.put(dp[i],map.getOrDefault(dp[i],0)+1);
            }
            
        }

        return dp[0];
    }
}

// class Solution {
//     private int[] a;
//     private int n;
//     private int k;

//     public int solve(int[] nums, int k) {
//         a = nums;
//         n = a.length;
//         this.k = k;

//         int[] dp = new int[n + 1];
//         dp[n - 1] = 0;

//         Deque<int[]> deque = new ArrayDeque<>();
//         deque.addFirst(new int[] {n - 1, a[n - 1]});

//         for (int i = n - 2; i >= 0; i--) {
//             while (deque.size() > 0 && deque.peekLast()[0] - i > k) {
//                 deque.pollLast();
//             }
//             dp[i] = deque.peekLast()[1];
//             while (deque.size() > 0 && deque.peekFirst()[1] >= a[i] + dp[i]) {
//                 deque.pollFirst();
//             }
//             deque.addFirst(new int[] {i, a[i] + dp[i]});
//         }

//         return dp[0] + a[0];
//     }

//     //-->adding [largest......smallest]<---removing from here

//     // private int solve(int i) {
//     //     //already at i
//     //     if (i==n-1) return 0;

//     //     int ans = (int)1e9;

//     //     for(int j=i+1; j<=i+k && j<n; j++) {
//     //         ans = Math.min(ans, a[j]+solve(j));
//     //     }

//     //     return ans;
//     // }
// }
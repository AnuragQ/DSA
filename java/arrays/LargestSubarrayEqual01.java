package arrays;

import java.util.HashMap;

public class LargestSubarrayEqual01 {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array

    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N) {
        // Your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        int sum = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }
            if (hm.containsKey(sum)) {
                ans = Math.max(ans, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return ans;

    }

}
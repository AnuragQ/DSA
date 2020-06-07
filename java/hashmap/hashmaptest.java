package java.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * hashmaptest
 */
public class hashmaptest {

    public static int[] fun(int[] data, int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (hm.containsKey(data[i])) {
                hm.replace(data[i], hm.get(data[i]) + 1);
            } else {
                hm.put(data[i], 1);
            }

        }
        int size = 0;
        ArrayList<Integer> allowed = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() <= n) {
                // System.out.println(("yes"));

                allowed.add(entry.getKey());
                size += entry.getValue();
            }

        }
        System.out.println(hm);

        // System.err.println(size);
        int[] ans = new int[size];
        int idx = 0;
        for (int i = 0; i < data.length; i++) {
            // allowed.contains(o)
            if (allowed.contains(data[i])) {
                // System.out.println(data[i]);
                ans[idx] = data[i];
                idx++;
            }
        }
        // System.out.println(hm);
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = 0;
        for (int i : fun(arr, n)) {
            System.out.println(i);
        }
    }
}
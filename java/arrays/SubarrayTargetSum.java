package java.arrays;

import java.io.*;

class SubArrayTargetSum {
    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String inp = br.readLine();
            String[] inpArr=inp.split(" ");
            int n = Integer.parseInt(inpArr[0]);
            int target = Integer.parseInt(inpArr[1]);
            String nums = br.readLine();
            long[] arr = new long[n];
            String[] numsarr=nums.split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(numsarr[i]);
            }
            long sum = arr[0];
            int left = 0, right = 1;
            while ((left <= right && sum != target)) {
                if (right < n && sum < target) {
                    sum += arr[right];
                    right++;
                } else if (left < n) {
                    sum -= arr[left];
                    left++;
                }
                // System.out.println(sum);
            }
            if (sum == target) {
                System.out.println((left + 1) + " " + (right));

            } else {
                System.out.println("-1");
            }

        }

        br.close();
    }

}
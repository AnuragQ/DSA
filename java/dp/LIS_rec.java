import java.io.*;

public class LIS_rec {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(bitonic(arr, 0, -1, true));
    }

    public static int bitonic(int[] arr, int idx, int li, boolean isIncreasing) {
        if (arr.length == idx) {
            return 0;
        }
        int rv = Integer.MIN_VALUE;
        rv = Math.max(rv, bitonic(arr, idx + 1, li, isIncreasing));
        
            if (li < 0 || arr[idx] > arr[li]) {
                rv = Math.max(rv, bitonic(arr, idx + 1, idx, true) + 1);

            }
        return rv;

    }
}
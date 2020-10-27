import java.util.*;

public class CountSubarraysWithEqual01 {

    public static int solution(int[] arr) {
        int N=arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        int sum = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }
            if (hm.containsKey(sum)) {
                ans+=hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            } else {
                hm.put(sum, 1);
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}

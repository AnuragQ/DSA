import java.util.*;
import java.util.HashMap;

public class CountSubstringsWithAtmostKdistinct {

    public static int solution(String str, int k) {
        int count = 0;
        int i = -1, j = -1;

        HashMap < Character, Integer > map = new HashMap < > ();
        while (true) {
            //Acquire
            while (i < str.length() - 1) {
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() <= k) {
                    int len = i - j;
                    count += len;
                } else {
                    break;
                }
            }

            if (i == str.length() - 1 && map.size() <= k) {
                break;
            }

            //release
            while (j < i) {
                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                if (map.size() <= k) {
                    int len = i - j;
                    count += len;
                    break;
                }
            }


        }

        return count;
    }
    public static int optimisedSolution(String str, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0 , j = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0) + 1);
            while(map.size() > k){
                char chj = str.charAt(j);
                map.put(chj,map.get(chj) - 1);
                if(map.get(chj) == 0){
                    map.remove(chj);
                }
                j++;
            }
            ans += (i - j + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }

}

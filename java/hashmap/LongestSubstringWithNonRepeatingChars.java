import java.util.*;

public class LongestSubstringWithNonRepeatingChars {

    public static int solution(String str) {
        int ans = 0;
        int i = -1, j = -1;
        HashMap < Character, Integer > map = new HashMap < > ();
        while (true) {
            // aquire
            boolean flag1=false;
            boolean flag2=false;
            while (i < str.length() - 1) {
                flag1=true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) == 2) {
                    break;
                } else {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                }
                
            }
            //release
            while (j < i) {
                flag2=true;
                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1)
                    break;
            }
            if (!flag1 && !flag2)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
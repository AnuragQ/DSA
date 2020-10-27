import java.util.*;

public class CountOfSubstringHavingAllUniqueChars {

    public static int solution(String str) {
        int count = 0;
        HashMap < Character, Integer > map = new HashMap < > ();
        int i = -1, j = -1;

        while (true) {
            boolean f1 = false, f2 = false;
            //  acquire
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                } else {
                    count += i - j;
                }
            }
            //  release
            while (j < str.length() - 1) {
                f2 = true;
                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    count += i - j;
                    break;
                }
            }
            if (!f1 && !f2) {
                break;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
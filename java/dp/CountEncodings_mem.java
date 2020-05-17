import java.io.*;

public class CountEncodings_mem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(countEncoding(str, 0, new int[str.length()]));
    }
    public static int countEncoding(String str, int idx,  int[] strg) {
        if (str.length() == 0) {
            return 1;
        }
        if (str.charAt(0) == '0') {
            return 0;
        }
        int ans = 0;
        // System.out.println(ans);
        int num = Integer.parseInt(str.substring(0, 1));
        if (num > 0) {
            ans += countEncoding(str.substring(1), ans + (char)('a' + num - 1),strg);
        }
        if (str.length() > 1) {
            num = Integer.parseInt(str.substring(0, 2));
            // System.out.print(num);
            if (num > 0 && num <= 26) {
                ans += countEncoding(str.substring(2), ans + (char)('a' + num - 1),strg);
            }
        }
        return ans;
    }
}
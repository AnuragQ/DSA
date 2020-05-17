import java.io.*;

public class LongesPalindromicSubsequence_rec {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        // String str3=br.readLine();
        String str2 = new StringBuilder(str1).reverse().toString();
        // System.out.println(str2);
        System.out.print(lcs(str1, str2));
    }

    public static int lcs(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int rv = Integer.MIN_VALUE;
        if (str1.charAt(0) == str2.charAt(0)) {
            rv = Math.max(rv, lcs(str1.substring(1), str2.substring(1)) + 1);

        } else {
            rv = Math.max(rv, lcs(str1.substring(1), str2));

            rv = Math.max(rv, lcs(str1, str2.substring(1)));

        }
        return rv;
    }
}
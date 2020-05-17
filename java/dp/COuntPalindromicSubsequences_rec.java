import java.io.*;

public class COuntPalindromicSubsequences_rec {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(countP(str));
    }
    public static int countP(String str) {
        if (str.length() == 1 || str.length() == 0) {
            return str.length();

        }
        int rv = countP(str.substring(1));
        rv += countP(str.substring(0, str.length() - 1));
        // rv-=countP(str.substring(1,str.length()-1));
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            rv += 1;
        } else {
            rv -= countP(str.substring(1, str.length() - 1));

        }
        return rv;
    }

}
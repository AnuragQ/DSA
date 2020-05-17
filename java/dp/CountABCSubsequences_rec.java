import java.io.*;

public class CountABCSubsequences_rec {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
    System.out.print(countabc(str,' '));
    }
    public static int countabc(String str, char prev) {
        if (str.length() == 0) {
            if (prev!=' ' && prev== 'c') {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        count += countabc(str.substring(1), prev);
        if (str.charAt(0) == 'a') {
            if (prev == ' ' || (prev!=' '  && prev== 'a')) {
                count += countabc(str.substring(1), str.charAt(0));
            }
        } else if (str.charAt(0) == 'b') {
            if (prev!=' ' &&( prev == 'a' || prev == 'b')) {
                count += countabc(str.substring(1),  str.charAt(0));

            }
        }else if (str.charAt(0) == 'c') {
            if (prev!=0 &&( prev == 'b' || prev == 'c')) {
                count += countabc(str.substring(1),  str.charAt(0));

            }
        }
        return count;




    }
}
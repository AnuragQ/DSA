package java.recursion;

// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// 3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
// Use the input-output below to get more understanding on what is required
// 123 -> abc, aw, lc
// 993 -> iic
// 013 -> Invalid input. A string starting with 0 will not be passed.
// 103 -> jc
// 303 -> No output possible. But such a string maybe passed. In this case print nothing.
import java.io.*;

public class print_encodings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        printEncodings(str, "");
        System.out.println();
    }

    public static void printEncodings(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        if(str.charAt(0)=='0'){
            return;
        }
        // System.out.println(ans);
        int num = Integer.parseInt(str.substring(0, 1));
        if (num > 0) {
            printEncodings(str.substring(1), ans + (char)('a'+num-1));
        }
        if (str.length() >1) {
            num = Integer.parseInt(str.substring(0, 2));
            // System.out.print(num);
            if (num > 0 && num <= 26) {
                printEncodings(str.substring(2), ans + (char)('a'+num-1));
            }
        }

    }

}
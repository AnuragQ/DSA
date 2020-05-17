
// import java.util.*;

public class decompressString {

    public static void main(String[] args) {
        // System.out.println("Hello World");
        String x = "aa12b10";
        String ans = "";
        int i = 0;
        // System.out.println(x);
        while (i < x.length()) {
            String ch = "";
            while (x.charAt(i) >= 'a' & x.charAt(i) <= 'z') {
                ch += x.charAt(i);
                i++;
            }

            int count = 0;
            // System.out.println(i);
            while (i < x.length()) {
                if ((x.charAt(i) >= '0' & x.charAt(i) <= '9')) {

                    // System.out.println(x.charAt(i));
                    // System.out.println(i);
                    count = count * 10 + (x.charAt(i) - '0');
                    i++;
                } else {
                    break;
                }

            }
            // System.out.println(count);

            for (int j = 0; j < count; j++) {
                ans += ch;
            }

            // System.out.println(ans);


        }

        System.out.println(ans);


    }
    // ans+=current;
    // ans+=count;


}

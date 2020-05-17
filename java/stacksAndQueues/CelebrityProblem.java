
import java.io.*;

public class CelebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"
        // System.out.print(0||0);
        int[] knows = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
             knows[i] = 0;
            // int isceleb=0;
            for (int j = 0; j < arr.length ; j++) {
                knows[i] = arr[i][j] | knows[i];
            }
        }
        // int[] knows = new int[arr.length];
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(knows[i]);
            if (knows[i] == 0) {
                int isceleb = 1;
                for (int j = 0; j < arr.length & j != i; j++) {
                    isceleb = isceleb & arr[j][i];
                }
                if (isceleb == 1) {
                    System.out.println(i);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("none");
        }
    }

}
package java.recursion;

import java.io.*;

public class PrintStairPaths {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {
        if (n == 0) {
            System.out.println(path);
        } else if (n < 0) {
            return;
        }
        printStairPaths(n - 1, path + '1');
        printStairPaths(n - 2, path + '2');

        printStairPaths(n - 3, path + '3');

    }

}
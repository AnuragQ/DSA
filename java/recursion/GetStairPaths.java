// package java.recursion;

// 1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
// 3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
import java.io.*;
import java.util.*;

public class GetStairPaths {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);

    }
// ArrayList<String> paths = getStairPaths(n);

public static ArrayList<String> getStairPaths(int n) {
    if (n == 0) {
        ArrayList<String> newarr = new ArrayList<>();
        newarr.add("");
        return newarr;
    }
    if (n < 0) {
        return new ArrayList<>();
    }
    ArrayList<String> myAns = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
        ArrayList<String> rv = getStairPaths(n - i);
        for (int j = 0; j < rv.size(); j++) {
            myAns.add(i + rv.get(j));
        }
    }
    return myAns;
}

}
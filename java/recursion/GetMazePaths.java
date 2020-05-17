// package java.recursion;

// 
// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
// 3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
import java.io.*;
import java.util.*;

public class GetMazePaths {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myAns = new ArrayList<>();
        if (sc <= dc) {
            ArrayList<String> rv = getMazePaths(sr, sc + 1, dr, dc);
            for (int i = 0; i < rv.size(); i++) {
                myAns.add("h" + rv.get(i));
            }
        }
        if (sr <= dr) {
            ArrayList<String> rv = getMazePaths(sr + 1, sc, dr, dc);
            for (int i = 0; i < rv.size(); i++) {
                myAns.add("v" + rv.get(i));
            }
        }
        return myAns;
    }

}
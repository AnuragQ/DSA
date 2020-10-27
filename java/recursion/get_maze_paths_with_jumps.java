// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
// 4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

import java.io.*;
import java.util.*;

public class get_maze_paths_with_jumps {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }
// ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);

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
    ArrayList<String> myans = new ArrayList<>();

    for (int i = 1; i <= dc - sc; i++) {
        ArrayList<String> rv = getMazePaths(sr, sc + i, dr, dc);
        for (int j = 0; j < rv.size(); j++) {
            myans.add("h" + i + rv.get(j));
        }
    }

    for (int i = 1; i <= dr - sr; i++) {
        ArrayList<String> rv = getMazePaths(sr + i, sc, dr, dc);
        for (int j = 0; j < rv.size(); j++) {
            myans.add("v" + i + rv.get(j));
        }

    }
    for (int i = 1; i <= Math.min(dc - sc, dr - sr); i++) {
        ArrayList<String> rv = getMazePaths(sr + i, sc + i, dr, dc);
        for (int j = 0; j < rv.size(); j++) {
            myans.add("d" + i + rv.get(j));
        }

    }
    return myans;

}

}
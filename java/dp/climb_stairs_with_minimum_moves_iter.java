package java.dp;

/*
LINK-https://www.pepcoding.com/resources/placement-bootcamp---batch-1/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move. 
You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of staircase.
Note -> If there is no path through the staircase print null.
*/

import java.io.*;

public class climb_stairs_with_minimum_moves_iter {

    public static void main(String[] args) throws Exception {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        System.out.println(getMinMoves(arr, 0, Integer.MAX_VALUE));
    }

    public static int getMinMoves(int[] arr, int idx, int msf) {
        if (idx == arr.length - 1) {
            return 0;
        }
        if (idx > arr.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (arr[idx] == 0) {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[idx]; i++) {
            int moves = getMinMoves(arr, idx + i, msf);

            ans = Math.min(moves, ans);

        }
        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        } else {
            ans += 1;
        }

        return ans;
    }

}
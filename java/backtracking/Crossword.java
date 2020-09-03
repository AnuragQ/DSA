import java.io.*;
import java.util.*;

public class Crossword {

    public static void solution(char[][] arr, String[] words, int vidx) {
        //write your code here
        if (vidx == words.length) {
            print(arr);
            return;
        }
        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {

                    if (canAddHorizontally(arr, i, j, word)) {
                        boolean[] chAdded = addHorizontally(arr, i, j, word);
                        solution(arr, words, vidx + 1);
                        print(arr);
                        removeHorizontally(arr, i, j, chAdded, word);
                    }
                    if (canAddVertically(arr, i, j, word)) {
                        boolean[] chAdded = addVertically(arr, i, j, word);
                        solution(arr, words, vidx + 1);
                        removeVertically(arr, i, j, chAdded, word);
                    }
                }
            }
        }




    }

    public static void removeHorizontally(char[][] arr, int i, int j, boolean[] added, String word) {
        for (int jj = 0; jj < word.length(); jj++) {
            if (added[jj]) {
                arr[i][j + jj] = '-';
            }
        }
    }

    public static void removeVertically(char[][] arr, int i, int j, boolean[] added, String word) {
        for (int ii = 0; ii < word.length(); ii++) {
            if (added[ii]) {
                arr[i + ii][j] = '-';
            }
        }
    }

    public static boolean[] addHorizontally(char[][] arr, int i, int j, String word) {
        boolean[] added = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                arr[i][j + jj] = word.charAt(jj);
                added[jj] = true;
            }
        }
        return added;

    }
    public static boolean[] addVertically(char[][] arr, int i, int j, String word) {
        boolean[] added = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                added[ii] = true;
            }
        }

        return added;
    }


    public static boolean canAddHorizontally(char[][] arr, int i, int j, String word) {

        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;

        }
        if (j + word.length() < arr[i].length && arr[i][j + word.length()] != '+') {
            return false;
        }

        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[i].length) {
                return false;
            }
            if (arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    public static boolean canAddVertically(char[][] arr, int i, int j, String word) {

        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;

        }
        if (i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
            return false;
        }

        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length) {
                return false;
            }
            if (arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }


    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}
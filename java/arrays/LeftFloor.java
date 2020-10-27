package arrays;

import java.io.*;
import java.util.TreeSet;

/**
 * main idea is to use a self balancing tree to store data and for each value
 * get the max from the tree strictly lower than current
 */
public class LeftFloor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split((" "));
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        TreeSet<Integer> ts = new TreeSet<>();
        int[] ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ts.add(arr[i]);
            ans[i]=ts.lower(arr[i])==null?-1:ts.lower(arr[i]);
        }
        for(int i=0;i<ans.length;i ++){
            System.out.print(ans[i]+" ");
        }
        

    }

}
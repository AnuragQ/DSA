package hashmap;

import java.io.*;
import java.util.*;

public class CommonElementsDistinct {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        int n2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        HashSet < Integer > hs = new HashSet < > ();

        for (int i = 0; i < n1; i++) {
            hs.add(arr1[i]);
        }
        // System.out.print(hs+" ");
        HashSet < Integer > ans = new HashSet < > ();
        for (int i = 0; i < n2; i++) {
            if (hs.contains(arr2[i])) {
                if (!ans.contains(arr2[i])) {
                    System.out.println(arr2[i]);
                    ans.add(arr2[i]);

                }
            }

        }



    }

}
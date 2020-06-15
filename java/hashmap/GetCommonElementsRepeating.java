package java.hashmap;

import java.io.*;
import java.util.*;
import java.util.HashMap;
public class GetCommonElementsRepeating {

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
// 
        HashMap < Integer,Integer > hm = new HashMap < > ();

        

        for (int i = 0; i < n1; i++) {
            hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
        }
        // System.out.println(hm+" ");
        for (int i = 0; i < n2; i++) {
            if (hm.containsKey(arr2[i])) {
                if (hm.get(arr2[i])>0) {
                    System.out.println(arr2[i]);
                    hm.put(arr2[i],hm.get(arr2[i])-1);

                }
            }

        }

 }

}
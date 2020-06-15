package java.hashmap;

import java.io.*;
import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashMap < Integer, Boolean > map = new HashMap < > ();
        for (int val: arr) {
            map.put(val, true);
        }
        
        for(int val:arr){
            if(map.containsKey(val-1)){
                map.put(val,false);
            }
        }
        
        int maxStartingPoint=0;
        int maxLength=0;
        
        for(int val:arr){
            
            if(map.get(val)){
                int len=0;
                int temp=val;
                while(map.containsKey(temp)){
                    temp++;
                    len++;
                }
                if(len>maxLength){
                    maxStartingPoint=val;
                    maxLength=len;
                }
            }
        }
        
        for(int i=maxStartingPoint;i<maxStartingPoint+maxLength;i++){
            System.out.println(i);
        }
    }

}
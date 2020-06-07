package java.hashmap;

import java.io.*;
import java.util.*;
import java.util.HashMap;

public class HighestOccuringCharacter {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          String str=br.readLine();
          HashMap<Character,Integer> hm=new HashMap<>();
        for(int i =0;i<str.length();i++){                                 
        // System.out.println(str.charAt(i));
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
            
        }
        
        int max=Integer.MIN_VALUE;
        char ch=' ';
        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                ch=entry.getKey();
            }
        }
        System.out.println(ch);
        
    }

}
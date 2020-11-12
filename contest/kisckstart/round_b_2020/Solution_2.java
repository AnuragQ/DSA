
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution_2 {
    

    /* package whatever //do not write package name here */
    
    
    public static long[] one_d(BufferedReader br) throws IOException{
        String[] inp = br.readLine().split(" ");
        long[] arr = new long[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(inp[i]);
        }
        return arr;
    }   
    public static String solution(BufferedReader br) throws IOException{
        long[] params=one_d(br);
        long[] arr=one_d(br);
        long n=params[0];
        
        long d=params[1];
        long ans=d;
        for(long i=n-1;i>=0;i--){
                ans=Math.min(ans,(d/arr[(int)i])*arr[(int)i]);
                d=ans;
        }
        return ""+ans;
    }

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            count++;            
            String ans=solution(br);
            System.out.println("Case #"+count+": "+ans);

        }
        

        br.close();

    }
}

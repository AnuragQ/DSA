
import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestArithmatic {
    

    /* package whatever //do not write package name here */
    
    
    public static int[] one_d(BufferedReader br) throws IOException{
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        return arr;
    }   
    public static String solution(BufferedReader br) throws IOException{
        int n = Integer.parseInt((br.readLine()));

        int[] arr=one_d(br);
        if(n<=2){
            return n+"";

        }
    
        int d =arr[1]-arr[0];
        int len=2;
        int maxLen=0;
        for(int i=2;i<n;i++){
            if(arr[i]-arr[i-1]==d){
                len++;
            }else{
                len=2;
                d=arr[i]-arr[i-1];
            }
            maxLen=Math.max(len, maxLen);

        }
        return maxLen+"";
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


import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution_1 {
    

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
        int[] params=one_d(br);
        int[] arr=one_d(br);
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=params[1]){
                count++;
                params[1]-=arr[i];
            }else{
                break;
            }
        }
        return ""+count;
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
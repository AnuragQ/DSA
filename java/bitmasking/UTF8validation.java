import java.io.*;
import java.util.*;

public class UTF8validation {

    public static boolean solution(int[] data) {
        //write your code here
        
        int rb=0;
        for(int i:data)
        {
            if(rb==0){
                // System.out.println(rb)
                if( (i >> 7) == 0b0){
                    continue;
                }else if( (i >> 5) == 0b110){
                     rb=1;
                }else if( (i >> 4) == 0b1110){
                     rb=2;
                }else if( (i >> 3) == 0b11110){
                     rb=3;
                }else{
                    return false;
                }
            }else{
                int mask=i >> 6;
                if(mask==0b10){
                    rb--;
                }else{
                    return false;
                }
            }
        }
       return rb==0;
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}
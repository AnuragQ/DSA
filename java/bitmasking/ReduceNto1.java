import java.io.*;
import java.util.*;

public class ReduceNto1 {

    public static int solution(long n) {
        //write your code here
        
        int count=0;
        while(n!=1){
            if( (n&1)==0){
                n>>=1;
            }else if(n==3){
                n--;
            }else if( (n&3)==1){
                n--;
            }else if( (n&3)==3 ){
                n++;
            }
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
    
    
}
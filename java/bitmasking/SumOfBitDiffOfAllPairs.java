import java.io.*;
import java.util.*;

public class SumOfBitDiffOfAllPairs {

  public static long solution(int[] arr){
    //write your code here
    long ans=0;
    for(int i=0;i<32;i++){
        int mask=1<<i;
        long zcount=0;
        long ocount=0;
        
        for(int val:arr){
            if( (val&mask)==0){
                zcount++;
            }else{
                ocount++;
            }
        }
        ans+=zcount*ocount*2;
        
    }
    
    
    
    return ans;
  }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
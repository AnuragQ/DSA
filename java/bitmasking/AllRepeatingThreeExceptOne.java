import java.io.*;
import java.util.*;

public class AllRepeatingThreeExceptOne {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   //write your code here
   int tn=0;
   int tnp1=~0;
   int tnp2=~0;
   
    for(int i=0;i<arr.length;i++){
        int num=arr[i];
        
        int common_tn=num&tn;
        int common_tnp1=num&tnp1;
        int common_tnp2=num&tnp2;
        tn&=~common_tn;
        tnp1|=common_tn;
        tnp1&=~common_tnp1;
        tnp2|=common_tnp1;
        tnp2&=~common_tnp2;
        tn|=common_tnp2;
        
        // my approach
        // while(common_tn!=0){
            
        //     int rmsb=common_tn&(-common_tn);
        //     tnp1=tnp1|rmsb;
        //     tn=tn&(~rmsb);
        //     common_tn=common_tn&(~rmsb);
        
        // }
        
        
        // while(common_tnp1!=0){
            
        //     int rmsb=common_tnp1&(-common_tnp1);
        //     tnp2=tnp2|rmsb;
        //     tnp1=tnp1&(~rmsb);
        //     common_tnp1=common_tnp1&(~rmsb);
        
        // }
        
        
        // while(common_tnp2!=0){
            
        //     int rmsb=common_tnp2&(-common_tnp2);
        //     tn=tn|rmsb;
        //     tnp2=tnp2&(~rmsb);
        //     common_tnp2=common_tnp2&(~rmsb);
        
        // }
    }
    
    System.out.println(tn);
   
   
  }

}
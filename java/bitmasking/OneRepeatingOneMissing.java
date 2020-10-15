import java.io.*;
import java.util.*;

public class OneRepeatingOneMissing {

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
   int xXORy=0;
   for(int i=0;i<arr.length;i++){
       xXORy^=(i+1)^arr[i];
       
   }
   
   int rmsb=xXORy & (-xXORy);
   
   int x=0;
   int y=0;
   
   for(int i=0;i<arr.length;i++){
        if( ( (i+1) & rmsb ) == 0){
            x^=(i+1);
        } else{
            y^=(i+1);
        }   
         if( (arr[i]&rmsb) == 0){
            x^=arr[i];
        } else{
            y^=arr[i];
        }   
   }
   int missing=0;
   for(int i=0;i<arr.length;i++){
       if(arr[i]==x){
           missing=y;
           break;
       }else if(arr[i]==y){
           missing=x;
           break;
       }
   }
   
   
   System.out.println("Missing Number -> "+(missing==x?x:y));
   System.out.println("Repeating Number -> "+(missing==y?x:y));
   
  }

}
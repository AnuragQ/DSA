import java.io.*;
import java.util.*;

public class AllRepeatingExceptTwo {

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
    for(int i:arr){
        xXORy=xXORy ^ i;
    }
    
    int rmsb=xXORy & (-xXORy);
    int x=0;
    int y=0;
    for(int i:arr){
        if( (i&rmsb) == 0 ){
            x=x^i;
        }else{
            y=y^i;
        }
    }
    
    System.out.println(x<y?x:y);
    System.out.println(x>y?x:y);

  }

}
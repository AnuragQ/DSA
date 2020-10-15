import java.io.*;
import java.util.*;

public class RightMostSetBit {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int pos=(n&-n);
    System.out.print(Integer.toBinaryString(pos));
    
    
    // My approach
    // int i=0;
    // while(( (~(1<<i++)) & n )==n);
    // System.out.print(Integer.toBinaryString(1<<(i-1)));
    
   
  }

}
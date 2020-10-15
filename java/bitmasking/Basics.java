// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/basics-of-bit-official/ojquestion#

// 1. You are given a number n.
// 2. Print the number produced on setting its i-th bit.
// 3. Print the number produced on unsetting its j-th bit.
// 4. Print the number produced on toggling its k-th bit.
// 5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.

import java.util.*;

public class Basics {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    System.out.println(n | (1<<i));
    System.out.println(n & (~(1<<j)));
    System.out.println(n ^ (1<<k));
    System.out.println( (n & (1<<m)) !=0 );
    
    scn.close();
    //write your code here
  }

}
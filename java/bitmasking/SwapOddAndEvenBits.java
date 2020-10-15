import java.util.*;

public class SwapOddAndEvenBits {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    scn.close();
    //write your code here

    System.out.println(((n&0x55555555)<<1)|((n&0xAAAAAAAA)>>1));
    
  }

}
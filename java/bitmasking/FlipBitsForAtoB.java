import java.util.*;

public class FlipBitsForAtoB {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    
    int xor=a^b;
    int count=0;
    
    while(xor>0 && ++count>0)xor-=(xor&(-xor));
    
    System.out.println(count);
    scn.close();
  }

}
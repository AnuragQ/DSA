import java.util.*;

public class IsPowerOf2 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    scn.close();
    //write your code here

        // n=n-(n&(-n));
        
    System.out.println((n&(n-1))==0);
  }

}
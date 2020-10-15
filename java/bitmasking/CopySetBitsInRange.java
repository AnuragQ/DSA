import java.util.*;

public class CopySetBitsInRange {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();
    scn.close();
    int m=1;
    m<<=right-left+1;
    m--;
    m<<=--left;
    System.out.println( m&a|b );
    

  }

}
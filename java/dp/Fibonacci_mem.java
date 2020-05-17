import java.util.*;

public class Fibonacci_mem{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc =new Scanner(System.in);
    int n=sc.nextInt();
    System.out.print(fib(n,new int[n+1]));
    sc.close();
 }
 static int fib(int n,int[] arr){
     if(n==0){
         return 0;
     }
     if(n==1){
         return 1;
     }
     if(arr[n]!=0){
         return arr[n];
     }
     arr[n]=fib(n-1,arr)+fib(n-2,arr);
     return arr[n];
     
 }

}
import java.util.*;

public class MaxSumIncreasingSubsequence_iter {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n=scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        
        int[] msis = new int[n];
        
        int ms=0;
        
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i]){
                    max=Math.max(max,msis[j]);
                }
            }
            msis[i]=max+arr[i];
            ms=Math.max(ms,msis[i]);
        }
        System.out.println(ms);

    }

}
import java.util.*;

public class LongestBitonicSubsequence_iter {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n=scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        int[] lis = new int[n];// longest increasing subsequence ending at i
        
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i]){
                    max=Math.max(max,lis[j]);
                }
            }
            lis[i]=max+1;
            
        }
        
        
        int[] lds = new int[n];  // longest decreasing subsequence starting from i
        
        for(int i=n-1;i>=0;i--){
            int max=0;
            for(int j=n-1;j>i;j--){
                if(arr[j]<=arr[i]){
                    max=Math.max(max,lds[j]);
                }
            }
            lds[i]=max+1;
            
        }
        
        int lbsl=0;
        
        for(int i=0;i<n;i++){
            lbsl=Math.max(lbsl,lds[i]+lis[i]-1);
        }
        
        System.out.println(lbsl);

    }

}
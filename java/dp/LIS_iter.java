import java.io.*;
import java.util.Arrays;

public class LIS_iter {
    
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //meaning for each i in lis array --> longest increasing subsequence ending on i
        int[] lis = new int[n];
        
        int lss=0;
        
        for(int i=0;i<n;i++){
            int max=0;
            // for(int j=0;j<i;j++){
            for(int j=Math.max(0,lss-1);j<i;j++){//small optimization

                if(arr[j]<arr[i]){
                    max=Math.max(max,lis[j]);
                }
            }
            lis[i]=max+1;
            lss=Math.max(lss,lis[i]);
        }
        System.out.println(lss);







        // int[] dp = new int[n];

        // dp[0] = 1;
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (arr[j] < arr[i]) {
        //             if (dp[j] > dp[i]) {
        //                 dp[i] = dp[j];
        //             }
        //         }

        //     }
        //     dp[i] += 1;
        // }
        // int ans = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        //     ans = Math.max(ans, dp[i]);
        // }
        // System.out.print(ans);
    }

    // O(NLogN)
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int j=0;
        Arrays.fill(arr,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            int idx=-1;
            int curval=nums[i];
            
            int lo=0;
            int hi=j;
            int mid=0;
            while(lo<=hi){

                mid=(lo+hi)/2;
                if(curval<=arr[mid]){
                    hi=mid-1;
                    idx=mid;

                }else{
                    lo=mid+1;
                }
            }

            if(idx==-1 ){

                arr[j]=curval;
                j++;
            }else{
                arr[idx]=curval;
            }
        }
        
        return j;
    }

}
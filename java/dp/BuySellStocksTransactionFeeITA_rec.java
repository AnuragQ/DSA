import java.io.*;

public class BuySellStocksTransactionFeeITA_rec {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int fee=Integer.parseInt(br.readLine());
        int ans=bs(arr,0,-1,fee);
        System.out.println(ans);

    }
    public static int bs(int[] arr,int idx,int li,int fee){
        if(arr.length==idx){
            return 0;
        }
        int ans=Integer.MIN_VALUE;
        if(li==-1){
            ans=Math.max(ans,bs(arr,idx+1,idx,fee));
        }
        else{
            if(arr[idx]>arr[li]){
                ans=Math.max(ans,bs(arr,idx+1,-1,fee)+arr[idx]-arr[li]-fee);
            }
        // ans=Math.max(ans,bs(arr,idx+1,li));
        }
            ans=Math.max(ans,bs(arr,idx+1,li,fee));

        return ans;
    }

}
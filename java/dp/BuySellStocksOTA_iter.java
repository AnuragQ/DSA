import java.io.*;

public class BuySellStocksOTA_iter {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans=0;
        int minval=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=minval){
                minval=arr[i];
            }
            else{
                ans=Math.max(ans,arr[i]-minval);
            }
        }
        System.out.println(ans);

    }

}
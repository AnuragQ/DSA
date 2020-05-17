import java.io.*;

public class MaxSumNonAdjacentElements_mem {

    public static void main(String[] args) throws IOException {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] strg=new int[n];
        // for (int i=0;i<n;i++){
        //     strg[i]=Integer.MIN_VALUE;
        // }
        System.out.print(maxSum(arr,0,strg));
    }
    public static int maxSum(int[] arr,int idx,int[] strg){
        if(idx>=arr.length){
            return 0;
        }
        //????
        // if(idx==arr.length-1){
        //     return arr[idx];
        // }
        if(strg[idx]!=0){
            return strg[idx];
        }
        int ans=Integer.MIN_VALUE;
        ans=Math.max(ans,maxSum(arr,idx+1,strg));
        ans=Math.max(ans,arr[idx]+maxSum(arr,idx+2,strg));
        strg[idx]=ans;
        return ans;
        
    }
}
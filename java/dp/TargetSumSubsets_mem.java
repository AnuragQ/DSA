import java.io.*;

public class TargetSumSubsets_mem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());
        int ans=targetSum(arr,0,tar,new int[n][tar+1]);
        if(ans==1){
            System.out.print("true");
        }else{
            System.out.print("false");
        }
    }
    public static int targetSum(int[] arr,int idx,int tar,int[][] strg){
        if(idx==arr.length){
            return 0;
        }
        if(tar<0){
            return 0;
        }
        if(tar==0){
            return 1;
        }
        if(strg[idx][tar]!=0){
            return strg[idx][tar];
        }
        int ans=0;
        if(targetSum(arr,idx+1,tar,strg)==1){
            ans=1;
        }
        if(targetSum(arr,idx+1,tar-arr[idx],strg)==1){
            ans=1;
        }
        strg[idx][tar]=ans;
        
        return ans;
            
        
        
    }
    
}
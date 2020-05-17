import java.io.*;

public class TargetSumSubsets_rec {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());
        int ans=targetSum(arr,0,tar);
        if(ans==1){
            System.out.print("true");
        }else{
            System.out.print("false");
        }
    }
    public static int targetSum(int[] arr,int idx,int tar){
        if(idx==arr.length){
            return 0;
        }
        if(tar<0){
            return 0;
        }
        if(tar==0){
            return 1;
        }
        int ans=0;
        if(targetSum(arr,idx+1,tar)==1){
            ans=1;
        }
        if(targetSum(arr,idx+1,tar-arr[idx])==1){
            ans=1;
        }
        return ans;
            
        
        
    }
    
}
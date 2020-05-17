import java.io.*;

public class ClimbStairsVariableJumps_mem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(getJumpCount(arr,0,new int[n]));

    }
    public static int getJumpCount(int[] arr,int  idx,int[] strg){
        if(arr.length-1==idx){
            return 1;
        }
        if(idx>arr.length-1){
            return 0;
        }
        
        if(strg[idx]!=0){
            return strg[idx];
        }
        int ans=0;
        for (int i=1;i<=arr[idx];i++){
            ans+=getJumpCount(arr,idx+i,strg);
        }
        strg[idx]=ans;
        return ans;
    }

}
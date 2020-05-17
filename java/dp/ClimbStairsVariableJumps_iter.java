import java.io.*;

public class ClimbStairsVariableJumps_iter {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] strg=new int[n];
        strg[n-1]=1;

        for (int i=n-2;i>=0;i--){
            int myans=0;

            for(int j =1;j<=arr[i];j++){
                if(i+j<n){
                                       myans+=strg[i+j]; 
                }
            }
            strg[i]=myans;

        }
        System.out.println(strg[0]);
        

    }
}
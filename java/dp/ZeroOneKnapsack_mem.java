import java.io.*;

public class ZeroOneKnapsack_mem {

    public static void main(String[] args) throws Exception {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }
                int cap = Integer.parseInt(br.readLine());

        System.out.println(getKS(values,wts,0,cap,new int[n][cap+1]));
    }
    public static int getKS(int[] values,int[] wts,int idx,int cap,int[][] strg){
        
        if(cap==0 ){
            return 0;
        }
         else if(cap<0){
            return -values[idx-1];
        }
        if(idx==wts.length-1){
            return 0;
        }
        if(strg[idx][cap]!=0){
            return strg[idx][cap];
        }

        int takeit=values[idx]+getKS(values,wts,idx+1,cap-wts[idx],strg);
        int not=getKS(values,wts,idx+1,cap,strg);
        int ans=Math.max(not,takeit);
        strg[idx][cap]=ans;
        return ans;
    }
}

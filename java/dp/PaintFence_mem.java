import java.io.*;

public class PaintFence_mem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.print(paintFence(n,k,new int[n+1][k+1]));
    }
    public static int paintFence(int n,int k,int[][] strg){
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        if(n==3){
            return k * (k - 1 + (k - 1) * k);
        }
        if(strg[n][k]!=0){
            return strg[n][k];
        }
        int ans=paintFence(n-1,k,strg)*k;
        ans-=paintFence(n-3,k,strg)*(k-1);
        strg[n][k]=ans;
        return ans;
    }
}
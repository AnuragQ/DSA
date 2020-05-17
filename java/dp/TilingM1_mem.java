import java.io.*;

public class TilingM1_mem {

    public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        System.out.println(tileCount(n,m,new int[n+1]));
    }
    public static int tileCount(int n,int m,int[] strg){
        if(n<=1){
            return 1;
        }
        if(strg[n]!=0){
            return strg[n];
        }
        int ans1=tileCount(n-1,m,strg);
        int ans2=0;
        if(n>=m){
            
            ans2=tileCount(n-m,m,strg);
        }
                    // System.out.println(n+" "+ans1+" "+ans2);
        strg[n]=ans1+ans2;
        return ans1+ans2;
    }
}
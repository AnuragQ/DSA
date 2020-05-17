import java.io.*;

public class PaintFence_rec {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.print(paintFence(n,k));
    }
    public static int paintFence(int n,int k){
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        if(n==3){
            return k * (k - 1 + (k - 1) * k);
        }
        int ans=paintFence(n-1,k)*k;
        ans-=paintFence(n-3,k)*(k-1);
        return ans;
    }
}
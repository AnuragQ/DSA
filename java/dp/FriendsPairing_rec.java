import java.io.*;

public class FriendsPairing_rec {

    public static void main(String[] args) throws Exception {
        // write your code here
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      System.out.println(getPair(n));
    }
    public static int getPair(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        int ans=0;
        ans+=getPair(n-1);
        ans+=(n-1)*getPair(n-2);
        return ans;
    }
}
import java.io.*;

public class ClimbStairs_iter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int [] strg=new int[n+1];
      
      strg[0]=1;
      strg[1]=1;
      strg[2]=2;
      for (int i=3;i<=n;i++){
          strg[i]=strg[i-1]+strg[i-2]+strg[i-3];
      }
      System.out.println(strg[n]);
      
        // write your code here
    }
    

}
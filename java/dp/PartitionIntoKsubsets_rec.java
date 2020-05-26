import java.io.*;
public class PartitionIntoKsubsets_rec {




    public static void main(String[] args) throws IOException {
        
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      System.out.println(getSet(n,k));
        
    }
    public static long getSet(int n,int k){
        if(k==0){
            return 0;
        }
        long ans=0;
        if(n<k){
            return 0;
        }
        if(n==k){
            return 1;
        }
        
        ans+=1*getSet(n-1,k-1);
        ans+=(k)*getSet(n-1,k);
        return ans;
        
        
        
        
        
        
    }
}

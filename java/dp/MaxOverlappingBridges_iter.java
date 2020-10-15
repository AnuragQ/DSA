import java.io.*;
import java.util.*;

public class MaxOverlappingBridges_iter {

    public static class Bridge {
        int north;
        int south;
        public Bridge(int north,int south){
            this.north=north;
            this.south=south;
        }
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        
        int n=Integer.parseInt(br.readLine());
        
        Bridge[] arr = new Bridge[n];
        for(int i=0;i<n;i++){
            String[] inp=br.readLine().split(" ");
            arr[i] = new Bridge(Integer.parseInt(inp[0]),Integer.parseInt(inp[1]));
        }
        
        Arrays.sort(arr,(Bridge x,Bridge y)->{
            if(x.north==y.north)
                return x.south-y.south;
            else
                return x.north-y.north;
            
        });
        
        int[] lis = new int[n];
        
        int lss=0;
        
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[j].south<=arr[i].south){
                    max=Math.max(max,lis[j]);
                }
            }
            lis[i]=max+1;
            lss=Math.max(lss,lis[i]);
        }
        System.out.println(lss);
    }

}
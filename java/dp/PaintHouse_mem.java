import java.io.*;

public class PaintHouse_mem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] items = str.split(" ");
            arr[i][0] = Integer.parseInt(items[0]);
            arr[i][1] = Integer.parseInt(items[1]);
            arr[i][2] = Integer.parseInt(items[2]);
        }
        
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,arr[0][2]+paintcost(arr,1,2,new int[n][3],3));
        ans=Math.min(ans,arr[0][1]+paintcost(arr,1,1,new int[n][3],3));
        ans=Math.min(ans,arr[0][0]+paintcost(arr,1,0,new int[n][3],3));
        System.out.print(ans);
        
    }
    public static  int paintcost(int[][] arr,int idx,int prev,int[][] strg,int cols){
        if(idx==arr.length){
            // return Math.min(arr[idx][col1],arr[idx][col2]);
            return 0;
        }
        if(strg[idx][prev]!=0){
            return strg[idx][prev];
        }
        // int col3=3-col1-col2;
        int ans=Integer.MAX_VALUE;
        // System.out.println(arr[idx][col3]);
        for(int i=0;i<cols;i++){
            if(i==prev){
                continue;
            }
        ans=Math.min(ans,arr[idx][i]+paintcost(arr,idx+1,i,strg,cols));}
        
        // ans=Math.min(ans,arr[idx][prev]+paintcost(arr,idx+1,col2,col3,strg));
        strg[idx][prev]=ans;
    return ans;
    }
}
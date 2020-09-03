import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 12
// 10
// 1 1 1 1 1 1 1 1 1 1
// 1 0 1 1 1 1 1 1 1 1
// 1 1 1 0 1 1 1 1 1 1
// 1 1 1 1 0 1 1 1 1 1
// 1 1 1 1 1 1 1 1 1 1
// 1 1 1 1 1 0 1 1 1 1
// 1 0 1 1 1 1 1 1 0 1
// 1 1 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1 1 1
// 0 1 1 1 1 0 1 1 1 1
// 1 1 1 1 1 1 1 1 1 1
// 1 1 1 0 1 1 1 1 1 1


public class Landmines {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int m=Integer.parseInt(br.readLine());//12
        int n=Integer.parseInt(br.readLine());//10
        int[][] arr=new int[m][n] ;
        for(int i=0;i<m;i++){
            String[] inp=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(inp[j]);
            } 
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    if(i>0){
                        arr[i-1][j]=2;
                    }
                    if(j>0){
                        arr[i][j-1]=2;
                    }
                    if(i<arr.length-1){
                        arr[i+1][j]=2;
                    }
                    if(j<arr[i].length-1){
                        arr[i][j+1]=2;
                    }
                }

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,solve(arr,i,0,new boolean[m][n],0));
        }
        System.out.println(ans);

        br.close();
    }

    private static int solve(int[][] arr, int row, int col, boolean[][] visited,int msf) {
        // System.out.println(col+" "+row);
        if(col<0 || row<0 ||row>=arr.length || col>=arr[row].length  || visited[row][col]==true || arr[row][col]==0 || arr[row][col]==2){
            return Integer.MAX_VALUE;
        } 
        if(col==arr[row].length-1){
            // System.out.println("here");
            return msf;
        }

        int ans=Integer.MAX_VALUE;
        visited[row][col]=true;
        ans=Math.min(ans,solve(arr,row+1,col,visited,msf+1));
        ans=Math.min(ans,solve(arr,row-1,col,visited,msf+1));
        ans=Math.min(ans,solve(arr,row,col+1,visited,msf+1));
        ans=Math.min(ans,solve(arr,row,col-1,visited,msf+1));

        visited[row][col]=false;


        
        return ans;
    }
    
}

import java.io.*;
import java.util.*;

public class countIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    bfs(arr, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);

        // write your code here
    }
    public static void bfs(int[][] graph, int i, int j) {
        // visited[vtx] = true;
        if(i<0 || i >=graph.length || j<0 ||j>=graph[i].length || graph[i][j]!=0){
            return;
        }
        graph[i][j]=2;
        
        bfs(graph,i+1,j);
        bfs(graph,i-1,j);
        bfs(graph,i,j-1);
        bfs(graph,i,j+1);
    }
    
    
}





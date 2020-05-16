package java.dp;

// 1. You are given a number n, representing the number of rows.

// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
// 4. You are standing in top-left cell and are required to move to bottom-right cell.
// 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
// 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
// 7. You are required to traverse through the matrix and print the cost of path which is least costly.

import java.io.*;

public class min_cost_in_maze_traversal_mem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }
      System.out.print(getCost(arr,0,n-1,0,m-1,new int[n][m]));
      
    }
    public  static int getCost(int[][] arr,int rs,int rd,int cs,int cd,int[][] strg){
        if(rs==rd && cs==cd){
            return arr[rs][cs];   
        }
        if(strg[rs][cs]!=0)
            return strg[rs][cs];
        int ans=Integer.MAX_VALUE;
        if(rs<rd){
            ans=Math.min(ans,getCost(arr,rs+1,rd,cs,cd,strg));
        }
        if(cs<cd){
            ans=Math.min(ans,getCost(arr,rs,rd,cs+1,cd,strg));
        }
        strg[rs][cs]=arr[rs][cs]+ans;
        return arr[rs][cs]+ans;
    }

}
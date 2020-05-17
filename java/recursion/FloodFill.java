

import java.io.*;

public class FloodFill {

   public static void main(String[] args) throws Exception {
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

      floodfill(arr, 0, 0, "");  
   }

   public static void floodfill(int[][] maze, int row, int col, String psf){
      if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || 
         maze[row][col] == 1 ){
         return;
      } else if(row == maze.length - 1 && col == maze[0].length - 1){
         System.out.println(psf);
         return;
      }

      maze[row][col] = 1;
      floodfill(maze, row - 1, col, psf + "t");
      floodfill(maze, row, col - 1, psf + "l");
      floodfill(maze, row + 1, col, psf + "d");
      floodfill(maze, row, col + 1, psf + "r");
      maze[row][col] = 0;
    //   System.out.println(psf);
   }

}
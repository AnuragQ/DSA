// import java.io.*;
import java.util.*;

public class Sudoku {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    if(i==board.length){
        display(board);
        return;
    }
    int ni=0;
    int nj=0;
    if(j==(board.length-1)){
        nj=0;
        ni=i+1;
    }else{
        ni=i;
        nj=j+1;
    }
    if(board[i][j]==0)
    {
        for(int po=1;po<=9;po++){
            
            if(isValid(board,i,j, po)==true){
                board[i][j]=po;
                solveSudoku(board,ni,nj);        
                board[i][j]=0;
            }
        }
    }else{
        solveSudoku(board,ni,nj);
    }
    
    
  }
    public static boolean isValid(int[][] board,int row,int col,int val){
        
        int smi=3*(row/3);
        int smj=3*(col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[smi+i][smj+j]==val){
                    return false;
                }
            }
        }
        
        for(int i=0;i<9;i++){
            if(board[row][i]==val || board[i][col]==val){
                return false;
            }
        }
        return true;
        
        
        
    }




  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}










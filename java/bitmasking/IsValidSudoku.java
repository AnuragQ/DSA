
class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] column = new int[9];
        int[][] sub = new int[3][3];
        
        for(int i=0;i<9;i++){
            
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                
                if( ((row[i]&(1<<(board[i][j]-'a')))!=0) ||  ((column[j]&(1<<(board[i][j]-'a')))!=0) || ((sub[i/3][j/3]&(1<<(board[i][j]-'a')))!=0) ){
                    return false;
                }
                else{
                    row[i]=row[i]|1<<(board[i][j]-'a');
                    column[j]=column[j]|1<<(board[i][j]-'a');
                    sub[i/3][j/3]=sub[i/3][j/3]|1<<(board[i][j]-'a');
                }
            }
        }
        
        return true;
        
    }
}
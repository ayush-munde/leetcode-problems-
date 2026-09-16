class Solution {
    public boolean isValid(int row, int col, char k,char[][] board){
        for(int i=0;i<9;i++){
             if(board[row][i]==k) return false;
             if(board[i][col]==k) return false;
        }
        int boxRow=3*(row/3);
        int boxCol=3*(col/3);

           for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                if(board[boxRow+j][boxCol+i]==k) return false;
            }
                
            }
            return true;
    }
    public boolean sudoku(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(i,j,k,board)){
                            board[i][j]=k;
                            if(sudoku(board)) return true;
                            board[i][j]='.';
                        }

                    }
                    return false;
                }
            }
        }
        return true;

    }
    public void solveSudoku(char[][] board) {
       sudoku(board);
        
    }
}
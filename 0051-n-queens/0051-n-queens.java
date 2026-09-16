class Solution {
    public void nQueen(List<List<String>> result,int col, int n,int[] leftRow,int []upperDiagonal,int []lowerDiagonal, char[][] board){
        if(col==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;

        }
        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && upperDiagonal[n-1+col-row]==0 && lowerDiagonal[col+row]==0){
                board[row][col]='Q';
                leftRow[row]=1;
                upperDiagonal[n-1+col-row]=1;
                lowerDiagonal[row+col]=1;

                 nQueen(result,col+1,n,leftRow,upperDiagonal,lowerDiagonal,board);

                  board[row][col]='.';
                leftRow[row]=0;
                upperDiagonal[n-1+col-row]=0;
                lowerDiagonal[col+row]=0;

            }
        }


    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        int [] leftRow= new int[n];
        int[] upperDiagonal=new int[2*n-1];
         int[] lowerDiagonal=new int[2*n-1];
         nQueen(result,0,n,leftRow,upperDiagonal,lowerDiagonal,board);

         return result;
    }
}
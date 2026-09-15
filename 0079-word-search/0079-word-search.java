class Solution {
    public boolean DFS(char[][] board, String word,int i,int j,int ind){
        if(word.length()==ind) return true;
        if(i<0||j<0||i>=board.length|| j>= board[0].length|| word.charAt(ind)!=board[i][j])
        return false;
        char temp=board[i][j];
        board[i][j]='#';
        boolean found =DFS(board,word,i+1,j,ind+1)||DFS(board,word,i-1,j,ind+1)||DFS(board,word,i,j+1,ind+1)||DFS(board,word,i,j-1,ind+1);
             board[i][j]=temp;
             return found;

    }
    public boolean exist(char[][] board, String word) {
        int rows=board.length;

        int cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(DFS(board,word,i,j,0)){
                    return true;
                }

            }
        }
        return false;
    }
}
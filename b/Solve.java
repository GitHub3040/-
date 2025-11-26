public class Solve {
    public void slove(char[][] board){
        int m=board.length;
        int n=board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0]=='O'){
                dfs(board,i,0,m,n);
            }
            if (board[i][n-1]=='O'){
                dfs(board,i,n-1,m,n);
            }
        }
        for (int j = 1; j < n-1; j++) {
            if (board[0][j]=='O'){
                dfs(board,0,j,m,n);
            }
            if (board[m-1][j]=='O'){
                dfs(board,m-1,j,m,n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='Z'){
                    board[i][j]='O';
                }
            }
        }
    }
    public static void dfs(char[][] board,int i,int j,int m,int n){
        if (i<0 || j<0 || i>=m || j>=n || board[i][j]!='O'){
            return ;
        }
        board[i][j]='Z';
        dfs(board,i+1,j,m,n);
        dfs(board,i-1,j,m,n);
        dfs(board,i,j+1,m,n);
        dfs(board,i,j-1,m,n);
    }
}

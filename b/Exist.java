public class Exist {
    public boolean exist(char[][] board,String  words){
        int m=board.length,n=board[0].length;
        char[] word=words.toCharArray();
        boolean ans=false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans|=dfs(board,word,i,j,0);
                if (ans){
                    return ans;
                }
            }
        }
        return ans;
    }

    public static boolean dfs(char[][] board,char[] word,int i,int j,int p){
        if (p==word.length){
            return true;
        }
        if (i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]!=word[p]){
            return false;
        }
        char tmp=board[i][j];
        board[i][j]='0';
        boolean ans=dfs(board,word,i+1,j,p+1)||dfs(board,word,i-1,j,p+1)||dfs(board,word,i,j+1,p+1)||dfs(board,word,i,j-1,p+1);
        board[i][j]=tmp;
        return ans;
    }
}

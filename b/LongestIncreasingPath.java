import java.util.Arrays;

public class LongestIncreasingPath{
    public int longestIncreasingPath(int[][] matrix){
        int m=matrix.length,n=matrix[0].length;
        int [][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=-1;
            }
        }
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans=Math.max(dfs(matrix,i,j,dp),ans);
            }
        }
        return ans;
    }
    public static int dfs(int [][] matrix,int i,int j,int[][] dp){
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if (i>0 && matrix[i][j]<matrix[i-1][j]){
            ans=Math.max(ans,dfs(matrix,i-1,j,dp));
        }
        if (i<matrix.length-1 && matrix[i+1][j]>matrix[i][j]){
            ans=Math.max(ans,dfs(matrix,i+1,j,dp));
        }
        if (j>0 && matrix[i][j]<matrix[i][j-1]){
            ans=Math.max(ans,dfs(matrix,i,j-1,dp));
        }
        if (j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j]){
            ans=Math.max(ans,dfs(matrix,i,j+1,dp));
        }
        dp[i][j]=ans+1;
        return ans+1;
    }
}

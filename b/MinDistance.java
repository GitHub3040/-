public class MinDistance {
    public int minDistance(String words1,String words2){
        char[] word1=words1.toCharArray();
        char[] word2=words2.toCharArray();
        int m=word1.length,n=word2.length;
        int [][] dp=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= n ; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1[i]==word2[j]){
                    dp[i+1][j+1]=dp[i][j];
                }else {
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j]+1,dp[i+1][j]+1),dp[i][j+1]+1);
                }
            }
        }
        return dp[m][n];
    }
    public int minDistance1(String words1,String words2){
        char[] word1=words1.toCharArray();
        char[] word2=words2.toCharArray();
        int m=word1.length,n=word2.length;
        int [] dp=new int[n+1];
        for (int i = 0; i <= n ; i++) {
            dp[i]=i;
        }
        for (int i = 0; i < m; i++) {
            int last=dp[0];
            dp[0]=i+1;
            for (int j = 0; j < n; j++) {
                int update=dp[j+1];
                if (word1[i]==word2[j]){
                    dp[j+1]=last;
                }else {
                    dp[j+1]=Math.min(Math.min(last+1,dp[j]+1),dp[j+1]+1);
                }
                last=update;
            }
        }
        return dp[n];
    }
}

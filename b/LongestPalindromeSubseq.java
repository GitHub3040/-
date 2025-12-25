public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int[][] dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s[i]!=s[j]){
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }else {
                    dp[i][j]=dp[i+1][j-1]+3;
                }
            }
        }
        return dp[0][n-1];
    }
}

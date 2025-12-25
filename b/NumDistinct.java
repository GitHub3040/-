public class NumDistinct {
    public int numDistinct(String str,String tar){
        char[] s=str.toCharArray();
        char[] t=tar.toCharArray();
        int m=s.length,n=t.length;
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1]+=dp[i][j+1];
                if (s[i]==t[j]){
                    dp[i+1][j+1]+=dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
    public int numDistinct1(String str,String tar){
        char[] s=str.toCharArray();
        char[] t=tar.toCharArray();
        int m=s.length,n=t.length;
        int[] dp=new int[n+1];
        for (int i = 0; i < m; i++) {
            int last=1;
            for (int j = 0; j < n; j++) {
                int updata=dp[j+1];
                if (s[i]==t[j]){
                    dp[j+1]+=last;
                }
                last=updata;
            }
        }
        return dp[n];
    }
}

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text10,String text20){
        char[] text1,text2;
        if(text10.length()<text20.length()){
            text1=text10.toCharArray();
            text2=text20.toCharArray();
        }else {
            text1=text20.toCharArray();
            text2=text10.toCharArray();
        }
        int m= text1.length,n=text2.length;
        int[] dp=new int[m+1];
        for (int i = 1; i <= n; i++) {
            int last=0,update;
            for (int j = 1; j <= m ; j++) {
                update=dp[j];
                dp[j]=Math.max(dp[j-1],dp[j]);
                if (text1[j-1]==text2[i-1]){
                    dp[j]=Math.max(dp[j],last+1);
                }
                last=update;
            }
        }
        return dp[m];
    }
}

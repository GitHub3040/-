public class LongestValidParentheses {
    public int longestValidParentheses(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int [] dp=new int[n+1];
        int ans=0;
        for (int i = 1,cnt=0; i < n; i++) {
            if (s[i]==')'){
                int p=i-dp[i-1]-1;
                if (p>=0 && s[p]=='('){
                    dp[i]=dp[i-1]+2+(p-1>=0 ? dp[p-1] : 0);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}

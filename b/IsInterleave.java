public class IsInterleave {
    public static boolean isInterleave(String ss1,String ss2,String ss3){
        char[] s1=ss1.toCharArray();
        char[] s2=ss2.toCharArray();
        char[] s3=ss3.toCharArray();
        int n1=s1.length,n2=s2.length,n3=s3.length;
        if (n1+n2!=n3){
            return false;
        }
        boolean [] dp=new boolean[n2+1];
        dp[0]=true;
        for (int i = 1; i <= n2; i++) {
            if (s2[i-1]!=s3[i-1]){
                break;
            }
            dp[i]=true;
        }
        int end=0;
        for (int i = 1; i <= n1 ; i++) {
            if (s1[i-1]!=s3[i-1]){
                break;
            }
            end=i;
        }
        for (int i = 1; i <= n1; i++) {
            dp[0]= i <= end;
            for (int j = 1; j <= n2; j++) {
                if (s1[i-1]!=s3[i+j-1]){
                    dp[j]=false;
                }
                if (s2[j-1]==s3[i+j-1]){
                    dp[j]|=dp[j-1];
                }
            }
        }
        return dp[n2];
    }
}

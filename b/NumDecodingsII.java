public class NumDecodingsII {
    private static int MOD=1_000_000_007;
    public int numDecodingsII(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        long[] dp=new long[n+1];
        dp[n]=1;
        for (int i = n-1; i >=0 ; i--) {
            if (s[i]!='0'){
                dp[i]=(s[i]=='*' ? 9:1)*dp[i+1];
                if (i+1<n){
                    if (s[i]=='*'){
                        if (s[i+1]=='*'){
                            dp[i]+=dp[i+2]*15;
                        }else {
                            dp[i]+=dp[i+2]*((s[i+1]-'0')<=6 ? 2 : 1);
                        }
                    }else {
                        if (s[i+1]=='*'){
                            if (s[i]=='1'){
                                dp[i]+=dp[i+2]*9;
                            }else if (s[i]=='2'){
                                dp[i]+=dp[i+2]*6;
                            }
                        }else {
                            if ((s[i]-'0')*10+(s[i+1]-'0')<=26){
                                dp[i]+=dp[i+2];
                            }
                        }
                    }
                }
            }
            dp[i]%=MOD;
        }
        return (int) dp[0];
    }
}

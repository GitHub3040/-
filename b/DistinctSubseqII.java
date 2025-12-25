public class DistinctSubseqII {
    private static int MOD=1_000_000_007;

//    从下标0~n：start:{} f0:{},{s[0]} f1: f0,f0|s[0]
    public int distinctSubseqII(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int [] dp=new int[26];
        int all=1;
        for (int i = 0,newSubString; i < n; i++) {
            int c=s[i]-'a';
            newSubString=(all-dp[c]+MOD)%MOD;
            dp[c]=(dp[c]+newSubString)%MOD;
            all=(all+newSubString)%MOD;
        }
        return (all-1+MOD)%MOD;
    }
}

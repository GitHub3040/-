import java.util.ArrayList;
import java.util.Arrays;

public class NumDecodings {
    public static int numDecodings(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int[] dp=new int[n+1];
        dp[n]=1;
        for (int i = n-1; i >=0 ; i--) {
            if (s[i]=='0'){
                continue;
            }else{
                dp[i]=dp[i+1];
                if (i+1<n && (s[i]-'0')*10+(s[i+1]-'0')<=26){
                    dp[i]+=dp[i+2];
                }
            }
        }
        return dp[0];
    }
    public static int numDecodings1(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(s,0,dp);
    }
    public static int dfs(char[] s,int i,int[] dp){
        if (i==s.length){
            return 1;
        }
        if (dp[i]!=-1){
            return dp[i];
        }
        int ans;
        if (s[i]=='0'){
            ans=0;
        }else{
            ans=dfs(s,i+1,dp);
            if (i+1<s.length && (s[i]-'0')*10+(s[i+1]-'0')<=26){
                ans+=dfs(s,i+2,dp);
            }
        }
        dp[i]=ans;
        return ans;
    }
    public static int numDecodings2(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int last=1,lastLast=0;
        for (int i = n-1,cur=0; i >=0 ; i--) {
            if (s[i]=='0'){
                cur=0;
            }else{
                cur=last;
                if (i+1<n && (s[i]-'0')*10+(s[i+1]-'0')<=26){
                    cur+=lastLast;
                }
            }
            lastLast=last;
            last=cur;
        }
        return last;
    }
}

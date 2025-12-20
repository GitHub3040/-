import java.io.FilterOutputStream;

public class FindSubstringInWraproundString {
    public static int findSubstringInWraproundString(String str){
        int n=str.length();
        int [] s=new int[n];
        int[] dp=new int[26];
        for (int i = 0; i < n; i++) {
            s[i]=str.charAt(i)-'a';
            if (i==0){
                dp[s[i]]++;
            }
        }
        for (int i = 1,len=1; i < n; i++) {
            if (s[i]-1==s[i-1] || (s[i]==0&&s[i-1]==25)){
                len++;
            }else {
                len=1;
            }
            dp[s[i]]=Math.max(dp[s[i]],len);
        }
        int ans=0;
        for (int i = 0; i < 26; i++) {
            ans+=dp[i];
        }
        return ans;
    }
    public static void main(String[] args){
        String s="zab";
        System.out.println(findSubstringInWraproundString(s));
    }
}

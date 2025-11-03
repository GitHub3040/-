import java.util.Arrays;

public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int [] cnts=new int[128];
        char[] str=s.toCharArray();
        int ans=0;
        for (int require = 1; require <= 26; require++) {
            Arrays.fill(cnts,0);
            for (int i = 0,l=0,collections=0,satisfy=0; i < s.length(); i++) {
                if (++cnts[str[i]]==1){
                    collections++;
                }
                if (cnts[str[i]]==k){
                    satisfy++;
                }
                while (collections>require){
                    if (cnts[str[l]]==1){
                        collections--;
                    }
                    if (cnts[str[l]]==k){
                        satisfy--;
                    }
                    cnts[str[l++]]--;
                }
                if (satisfy==collections){
                    ans=Math.max(ans,i-l+1);
                }
            }
        }
        return ans;
    }
}

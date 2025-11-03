import java.util.Arrays;
import java.util.HashSet;

public class LengthOfLongSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ans=0,left=0;
        HashSet set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }
            ans=Math.max(ans,i-left+1);
            set.add(s.charAt(i));
        }
        return ans;
    }
    public int lengthOfLongestSubstring1(String s){
        char [] ch=s.toCharArray();
        int [] last=new int[256];
        Arrays.fill(last,-1);
        int ans=0;
        for (int i = 0,left=0; i < s.length(); i++) {
            left=Math.max(left,last[ch[i]]+1);
            ans=Math.max(ans,i-left+1);
            last[ch[i]]=0;
        }
        return ans;
    }
}

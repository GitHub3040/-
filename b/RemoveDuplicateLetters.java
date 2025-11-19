import java.awt.event.ActionListener;
import java.util.Arrays;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String str){
        int n=str.length();
        char[] s=str.toCharArray();
        char [] stack=new char[n];
        int [] cnt=new int[26];
        boolean [] enter=new boolean[26];
        Arrays.fill(enter,false);
        int r=0;
        for (int i = 0; i < n ; i++) {
            cnt[s[i]-'a']+=1;
        }
        for (int i = 0; i < n; i++) {
            if (!enter[s[i]-'a']){
                while (r > 0 && stack[r - 1] > s[i] && cnt[stack[r - 1] - 'a'] > 0) {
                    enter[stack[r-1]-'a']=false;
                    r--;
                }
                stack[r++] = s[i];
                enter[s[i]-'a']=true;
            }
            cnt[s[i]-'a']--;
        }
        return String.valueOf(stack, 0, r);
    }
}

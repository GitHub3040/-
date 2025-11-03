import java.util.HashMap;

public class MinWindow {
    public static String minWindow1(String str,String tar){
        char[] s = str.toCharArray();
        char[] t = tar.toCharArray();
        // 每种字符的欠债情况
        // cnts[i] = 负数，代表字符i有负债
        // cnts[i] = 正数，代表字符i有盈余
        int[] cnts = new int[256];
        for (char cha : t) {
            cnts[cha]--;
        }
        // 最小覆盖子串的长度
        int len = Integer.MAX_VALUE;
        // 从哪个位置开头，发现的最小覆盖子串
        int start = 0;
        // 总债务
        int debt = t.length;
        for (int l = 0, r = 0; r < s.length; r++) {
            // 窗口右边界向右，给出字符
            if (cnts[s[r]]++ < 0) {
                debt--;
            }
            if (debt == 0) {
                // 窗口左边界向右，拿回字符
                while (cnts[s[l]] > 0) {
                    cnts[s[l++]]--;
                }
                // 以r位置结尾的达标窗口，更新答案
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);
    }

    public static String minWindow(String str,String tar){
        char[] s=str.toCharArray();
        char[] t=tar.toCharArray();
        if (s.length<t.length){
            return "";
        }
        HashMap<Character,Integer> target=new HashMap<>();
        for (int i = 0; i < t.length; i++) {
            target.put(t[i],target.getOrDefault(t[i],0)+1);
        }
        int left=0,ans=Integer.MAX_VALUE,size=target.size();
        StringBuilder tmp=new StringBuilder();
        String fin="";
        for (int i = 0; i < s.length; i++) {
            tmp.append(s[i]);
            if (target.containsKey(s[i])){
                target.put(s[i],target.get(s[i])-1);
                if (target.get(s[i])==0){
                    size-=1;
                }
            }
            while (size==0){
                if (i-left+1<ans){
                    fin=tmp.toString();
                    ans=tmp.length();
                }
                if (target.containsKey(s[left])){
                    target.put(s[left], target.get(s[left]) + 1);
                    if (target.get(s[left++])>0){
                        size++;
                    }
                }else {
                    left++;
                }
                tmp.deleteCharAt(0);
            }
        }
        return fin;
    }
    public static void main(String[] args){
        String s1="cabwefgewcwaefgcf";
        String s2="cae";
        System.out.println(minWindow(s1,s2));
    }
}

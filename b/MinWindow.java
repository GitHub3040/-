import java.util.HashMap;

public class MinWindow {
    public static String minWindow1(String str,String tar){
        char[] s=str.toCharArray();
        char[] t=tar.toCharArray();
        if (s.length<t.length){
            return "";
        }
        int [] last=new int[128];
        int size=0;
        for (int i = 0; i < t.length; i++) {
            last[t[i]]++;
            size++;
        }
        int start=0,left = 0,minlen=Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            if (last[s[i]]>0){
                size--;
            }
            last[s[i]]--;
            while (size==0){
                if (i-left+1<minlen){
                    minlen=i-left+1;
                    start=left;
                }
                last[s[left]]++;
                if (last[s[left]]>0){
                    size++;
                }
                left++;
            }
        }
        return minlen==Integer.MAX_VALUE ? "" : str.substring(start,minlen);
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MinStickers {
    private static int MAXN=401;
    private static String[] queue=new String[MAXN];
    public int minStickers(String[] stickers,String target){
        ArrayList<ArrayList<String>> graph=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        for (String str:stickers){
            str=sort(str);
            for (int i = 0; i < str.length(); i++) {
                if (i==0 || str.charAt(i)!=str.charAt(i-1)){
                    graph.get(str.charAt(i)-'a').add(str);
                }
            }
        }
        int r=0,l=0;
        queue[r++]=sort(target);
        HashSet<String > set=new HashSet<>();
        int level=1;
        while (r>l){
            int size=r-l;
            for (int i = 0; i < size; i++) {
                String cur=queue[l++];
                for (String s:graph.get(cur.charAt(0)-'a')){
                    String next=next(cur,s);
                    if (!set.contains(next)){
                        set.add(next);
                        queue[r++]=next;
                    }
                    if (next.isEmpty()) {
                        return level;
                    }
                }
            }
            level++;
        }
        return -1;
    }
    public static String next(String cur,String s){
        StringBuilder builder=new StringBuilder();
        for (int i = 0,j=0; i < cur.length();) {
            if (j == s.length()) {
                builder.append(cur.charAt(i++));
            } else {
                if (cur.charAt(i) < s.charAt(j)) {
                    builder.append(cur.charAt(i++));
                } else if (cur.charAt(i) > s.charAt(j)) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return builder.toString();
    }
    public static String sort(String str) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        return String.valueOf(s);
    }

}

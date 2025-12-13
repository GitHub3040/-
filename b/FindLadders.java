
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindLadders {
    private static HashSet<String> dict;
    private static HashSet<String> cur=new HashSet<>();
    private static HashSet<String> next=new HashSet<>();
    private static HashMap<String,ArrayList<String>> graph=new HashMap<>();
    private static  List<List<String>> ans=new ArrayList<>();
    private static List<String> path=new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        build(wordList);
        if (!dict.contains(endWord)){
            return ans;
        }
        if (bfs(beginWord,endWord)){
            dfs(endWord,beginWord);
        }
        return ans;
    }
    public static void dfs(String beginWord,String aim){
        path.addFirst(beginWord);
        if (beginWord.equals(aim)){
            ans.add(new ArrayList<>(path));
        }else {
            for (String nxt:graph.get(beginWord)) {
                dfs(nxt,aim);
            }
        }
        path.removeFirst();
    }
    public static void build(List<String> wordList){
        dict=new HashSet<>(wordList);
        cur.clear();
        next.clear();
        graph.clear();
        ans.clear();
    }
    public static boolean bfs(String beginWord,String endWord){
        boolean find=false;
        cur.add(beginWord);
        while (!cur.isEmpty()){
            dict.removeAll(cur);
            for (String word:cur){
                char[] w=word.toCharArray();
                for (int i = 0; i < w.length; i++) {
                    char old = w[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        w[i] = j;
                        String val = String.valueOf(w);
                        if (dict.contains(val)) {
                            if (val.equals(endWord)) {
                                find=true;
                            }
                            next.add(val);
                            graph.putIfAbsent(val, new ArrayList<String>());
                            graph.get(val).add(word);
                        }
                    }
                    w[i]=old;
                }
            }
            if (find){
                return find;
            }else {
                HashSet<String> tmp=cur;
                cur=next;
                next=tmp;
                next.clear();
            }
        }
        return false;
    }
}

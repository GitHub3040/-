import java.io.*;
import java.util.Arrays;

public class Trie {
    private static int MAXN= 150001;
    private static int [][] tree=new int[MAXN][26];
    private static int [] pass=new int[MAXN];
    private static int [] end=new int[MAXN];
    private static int cnt;
    //    public  static class TrieNode{
//        public int pass;
//        public int end;
//        public  TrieNode[] nexts;
//        public TrieNode(){
//            pass=0;
//            end=0;
//            nexts=new TrieNode[26];
//        }
//    }

//    private static TrieNode root;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        cnt=1;
        in.nextToken();
        int m=(int) in.nval;
        for (int i = 0; i < m; i++) {
            in.nextToken();
            int op=(int) in.nval;
            in.nextToken();
            if (op==1){
                insert(in.sval);
            } else if (op==2) {
                erase(in.sval);
            }else if (op==3){
                out.println(isexist(in.sval) ? "YES" : "NO");
            }else {
                out.println(count(in.sval));
            }
        }
        clear();
        out.flush();
        out.close();
        br.close();
    }
    public static void insert(String word){
        int cur=1;
        pass[cur]++;
        for (int i = 0; i < word.length(); i++) {
            int c=word.charAt(i)-'a';
            if (tree[cur][c]==0){
                tree[cur][c]=++cnt;
            }
            cur=tree[cur][c];
            pass[cur]++;
        }
        end[cur]++;
    }

    public static void erase(String word){
        int cur=1;
        if (!isexist(word)){
            return ;
        }
        pass[cur]--;
        for (int i = 0; i < word.length(); i++) {
            int c=word.charAt(i)-'a';
            if (--pass[tree[cur][c]]==0){
                tree[cur][c]=0;
                return ;
            }
            cur=tree[cur][c];
        }
        end[cur]--;
    }
    public static boolean  isexist(String word){
        int cur=1;
        for (int i = 0; i < word.length(); i++) {
            int c=word.charAt(i)-'a';
            if (tree[cur][c] == 0) {
                return false;
            }
            cur=tree[cur][c];
        }
        return end[cur]!=0;
    }
    public  static int count(String word){
        int cur=1;
        for (int i = 0; i < word.length(); i++) {
            int c=word.charAt(i)-'a';
            if (tree[cur][c]==0){
                return 0;
            }
            cur=tree[cur][c];
        }
        return pass[cur];
    }
    public static void clear(){
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i],0);
            pass[i]=0;
            end[i]=0;
        }
    }
}


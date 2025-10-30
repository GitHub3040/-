import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindWords {
    private static int MAXN=300001;
    private static int[][] tree=new int[MAXN][26];
    private static int[] pass=new int[MAXN];
    private static String[] end=new String[MAXN];
    private static int cnt;
    public static void build(){
        cnt=1;
    }
    public static void  clear(){
        for (int i = 0; i <= cnt; i++) {
            Arrays.fill(tree[i],0);
            pass[i]=0;
            end[i]=null;
        }
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
        end[cur]=word;
    }
    public List<String> findWords(char[][] board,String[] words){
        build();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        List<String> ans=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                f(i,j,1,board,ans);
            }
        }
        clear();
        return ans;
    }
    public static int f(int i,int j,int cur,char[][] board,List<String > ans){
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 0) {
            return 0;
        }
        char temp=board[i][j];
        int road=temp-'a';
        cur=tree[cur][road];
        if(pass[cur]==0){
            return 0;
        }
        int fix=0;
        if (end[cur]!=null){
            fix++;
            ans.add(end[cur]);
            end[cur]=null;
        }
        board[i][j]=0;
        fix+=f(i+1,j,cur,board,ans);
        fix+=f(i-1,j,cur,board,ans);
        fix+=f(i,j+1,cur,board,ans);
        fix+=f(i,j-1,cur,board,ans);
        board[i][j]=temp;
        pass[cur]-=fix;
        return fix;
    }
}

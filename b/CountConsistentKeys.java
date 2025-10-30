import java.util.Arrays;

public class CountConsistentKeys {
    private static int MAXN=200001;
    private static int[][] tree=new int[MAXN][12];
    private static int[] pass=new int[MAXN];
    private static int cnt;
    public static int getpath(char ch){
        if (ch=='#'){
            return 10;
        }else if (ch=='-'){
            return 11;
        }else {
            return ch-'0';
        }
    }
    public static void insert(String word){
        int cur=1;
        pass[cur]++;
        for (int i = 0; i < word.length(); i++) {
            int c=getpath(word.charAt(i));
            if (tree[cur][c] == 0) {
                tree[cur][c] = ++cnt;
            }
            cur = tree[cur][c];
            pass[cur]++;
        }
    }
    public static int count(String word){
        int cur=1;
        for (int i = 0; i < word.length(); i++) {
            int c=getpath(word.charAt(i));
            if (tree[cur][c] == 0) {
                return 0;
            }
            cur = tree[cur][c];
        }
        return pass[cur];
    }
    public static void clear(){
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i],0);
            pass[i]=0;
        }
    }
    public static void build(){
        cnt=1;
    }
    public static int[] countConsistentKeys(int[][] b,int [][] a){
        build();
        StringBuilder builder=new StringBuilder();
        for(int[] nums : a){
            builder.setLength(0);
            for (int i = 1; i < nums.length; i++) {
                builder.append(nums[i] - nums[i - 1] +"#");
            }
            insert(builder.toString());
        }
        int [] ans=new int[b.length];
        for (int i = 0; i < b.length; i++) {
            builder.setLength(0);
            int [] nums=b[i];
            for (int j=1;j<nums.length;j++) {
                builder.append(nums[j] - nums[j - 1] +"#");
            }
            ans[i]=count(builder.toString());
        }
        clear();
        return ans;
    }
}

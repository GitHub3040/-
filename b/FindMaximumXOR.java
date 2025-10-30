import java.util.Arrays;
import java.util.HashSet;

public class FindMaximumXOR {
    private static int MAXN= 3000001;
    private static int [][] tree=new int[MAXN][2];
    private static int cnt;
    private static int top;
    public static int findMaximumXOR(int [] nums){
        int mx=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            mx=Math.max(mx,nums[i]);
        }
        top=31-Integer.numberOfLeadingZeros(mx);
        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        for (int i=top;i>=0;i--) {
            set.clear();
            int batter=ans|(1<<i);
            for (int num:nums){
                int x=(num>>>i)<<i;
                if (set.contains(ans^batter)){
                    ans=batter;
                    break;
                }
                set.add(x);
            }
        }
        return ans;
    }
    public static int findMaxmumXOR1(int [] nums){
        build(nums);
        int ans=0;
        for (int num:nums) {
            ans=Math.max(ans,maxXOr(num));
        }
        clear();
        return ans;
    }
    public static int maxXOr(int num){
        int cur=1;
        int ans=0;
        for (int i = top; i >= 0; i--) {
            int c=(num>>>i)&1;
            int want=c^1;
            if (tree[cur][want]==0){
                want=want^1;
            }
            cur=tree[cur][want];
            ans=ans|((want^c)<<i);
        }
        return ans;
    }
    public static void build(int [] nums){
        cnt=1;
        int mx=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            mx=Math.max(mx,nums[i]);
        }
        top=31-Integer.numberOfLeadingZeros(mx);
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }
    public static void insert(int word){
        int cur=1;
        for (int i = top; i >= 0; i--){
            int c = (word>>>i)&1;
            if (tree[cur][c] == 0) {
                tree[cur][c] = ++cnt;
            }
            cur = tree[cur][c];
        }
    }
    public static void clear(){
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i],0);
        }
    }
}

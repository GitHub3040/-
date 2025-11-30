import javax.swing.plaf.PanelUI;
import java.io.*;
import java.lang.management.MemoryNotificationInfo;
import java.util.Arrays;

public class FoodLines {
    private static int m,n;
    private static int MAXN=5001;
    private static int MAXM=500001;
    private static int[] head=new int[MAXN];
    private static int[] to=new int[MAXM];
    private static int[] next=new int[MAXM];

    private static int[] indegree=new int[MAXN];
    private static int[] nums=new int[MAXN];
    private static int cnt;

    private static int MOD=80112002;

    private static int[] queue=new int[MAXN];
    private static int r,l;

    public static void build(){
        cnt=1;
        Arrays.fill(head,1,n+1,0);
        Arrays.fill(indegree,0,n+1,0);
        Arrays.fill(nums,0,n,0);
    }

    public static void addEdge(int u,int v){
        next[cnt]=head[u];
        to[cnt]=v;
        head[u]=cnt++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            in.nextToken();
            m=(int) in.nval;
            build();
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int u=(int) in.nval;
                in.nextToken();
                int v=(int) in.nval;
                addEdge(u,v);
                indegree[v]++;
            }
            int ans=f();
            out.println(ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int f(){
        r=0;
        l=0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i]==0){
                queue[r++]=i;
                nums[i]=1;
            }
        }
        int ans=0;
        while (r>l){
            int cur=queue[l++];
            if (head[cur]==0){
                ans=(ans+nums[cur])%MOD;
            }
            for (int ei = head[cur]; ei>0; ei=next[ei]) {
                indegree[to[ei]]--;
                nums[to[ei]]=(nums[cur]+nums[to[ei]])%MOD;
                if (indegree[to[ei]]==0){
                    queue[r++]=to[ei];
                }
            }
        }
        return ans;
    }
}

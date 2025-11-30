import java.util.Arrays;

public class AlienOrder {
    private static int MAXN=30;
    private static int MAXM=1000;
    private static int[] head=new int[MAXN];
    private static int[] to=new int[MAXM];
    private static int[] next=new int[MAXM];
    private static int[] indegree=new int[26];
    private static int cnt;

    private static int[] queue=new int[MAXN];
    private static int l,r;

    public static void build(int n){
        Arrays.fill(head,0,n,0);
        Arrays.fill(indegree,0,n,-1);
        cnt=1;
    }

    public static void addEdge(int u,int v){
        next[cnt]=head[u];
        to[cnt]=v;
        head[u]=cnt++;
    }

    public String alienOrder(String[] works){
        int m=works.length;
        build(26);
        for (int i = 0; i < m; i++) {
            for (char c:works[i].toCharArray()){
                indegree[c-'a']=0;
            }
        }
        for (int i = 1; i < m; i++) {
            char[] x=works[i].toCharArray(),y=works[i-1].toCharArray();
            int k = 0;
            int minLen = Math.min(x.length, y.length);
            for (; k < minLen; k++) {
                if (x[k] != y[k]) {
                    int u = y[k] - 'a', v = x[k] - 'a';
                    addEdge(u, v);
                    indegree[v]++;
                    break;
                }
            }
            if (k == minLen && y.length > x.length) {
                return "";
            }
        }
        StringBuilder ans=new StringBuilder();
        l=0;
        r=0;
        int kind=0;
        for (int i = 0;i<26 ; i++) {
            if (indegree[i]!=-1){
                kind++;
            }
            if (indegree[i]==0){
                queue[r++]=i;
            }
        }
        while (r>l){
            int c=queue[l++];
            ans.append((char) (c+'a'));
            for (int ei=head[c]; ei >0 ; ei=next[ei]) {
                if (--indegree[to[ei]]==0){
                    queue[r++]=to[ei];
                }
            }
        }
        return ans.length()==kind ? ans.toString() : "";
    }
}

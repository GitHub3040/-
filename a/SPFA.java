import java.io.*;
import java.util.Arrays;

public class SPFA {
    private static int m,n;
    private static int MAXN=2001;
    private static int MAXM=3001;
    private static int[] head=new int[MAXN];
    private static int[] next=new int[MAXM];
    private static int[] to=new int[MAXM];
    private static int[] weight=new int[MAXM];
    private static int[] distance=new int[MAXN];
    private static int cnt;

    private static int MAXQ=6000001;
    private static boolean[] enter=new boolean[MAXN];
    private static int[] queue=new int[MAXQ];
    private static int[] updateCnt=new int[MAXN];
    private static int l,r;

    public static void build(){
        cnt=1;
        l=0;r=0;
        Arrays.fill(head,1,n+1,0);
        Arrays.fill(distance,1,n+1,Integer.MAX_VALUE);
        Arrays.fill(updateCnt,1,n+1,Integer.MAX_VALUE);
        Arrays.fill(enter,1,n+1,false);
    }

    public static void addEdge(int u,int v,int w){
        next[cnt]=head[u];
        to[cnt]=v;
        weight[cnt]=w;
        head[u]=cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(bf);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            int t=(int) in.nval;
            in.nextToken();
            for (int i = 0; i < t; i++) {
                n=(int) in.nval;
                in.nextToken();
                m=(int) in.nval;
                build();
                for (int j = 0,u,v,w; j < m; j++) {
                    in.nextToken();
                    u = (int) in.nval;
                    in.nextToken();
                    v = (int) in.nval;
                    in.nextToken();
                    w = (int) in.nval;
                    addEdge(u, v, w);
                }
                out.println(SPFA() ? "YEA" : "NO");
            }
        }
        out.flush();
        out.close();
        bf.close();
    }


    public static boolean SPFA(){
       distance[1]=0;
       updateCnt[1]++;
       queue[r++]=1;
       enter[1]=true;
       while (r>l){
           int cur=queue[l++];
           enter[cur]=false;
           for (int ei = head[cur]; ei >0 ; ei=next[ei]) {
               if (distance[cur]+weight[ei]<distance[to[ei]]){
                   distance[to[ei]]=distance[cur]+weight[ei];
                   if (!enter[to[ei]]){
                       if (++updateCnt[to[ei]]>=n){
                           return true;
                       }
                       queue[r++]=to[ei];
                       enter[to[ei]]=true;
                   }
               }
           }
       }
       return false;
    }
}

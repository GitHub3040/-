import java.io.*;
import java.util.Arrays;

public class FindMinimumCost {
    private static int n,m;
    private static int MAXM=8001;
    private static int MAXN=301;
    private static int[][] edge=new int[MAXM][3];
    private static int[] father=new int[MAXN];
    public static void build(){
        for (int i = 0; i < n; i++) {
            father[i]=i;
        }
    }
    public static int find(int x){
        if (x!=father[x]){
            father[x]=find(father[x]);
        }
        return father[x];
    }
    public static boolean union(int x,int z){
        int fx=find(x);
        int fy=find(z);
        if (fx==fy){
            return false;
        }else {
            father[fy]=fx;
            return true;
        }
    }
    public static void main(String[] args) throws IOException{
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
                int u=(int) in.nval;in.nextToken();
                int v=(int) in.nval;in.nextToken();
                int w=(int) in.nval;
                edge[i][0]=u;
                edge[i][1]=v;
                edge[i][2]=w;
            }
            Arrays.sort(edge,0,m,(a,b)->a[2]-b[2]);
            int cost=0,num=0;
            for (int i = 0,u,v,w; i < m; i++) {
                u=edge[i][0];
                v=edge[i][1];
                w=edge[i][2];
                if (union(u,v)){
                    cost=Math.max(cost,w);
                    num++;
                }
            }
            out.println(num+" "+cost);
        }
        out.flush();
        out.close();
        br.close();
    }
}

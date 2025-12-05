import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimEnhance {
    private static int MAXN=5001;
    private static int MAXM=400001;
    private static int m,n;

    private static int [] head=new int[MAXN];
    private static int [] to=new int[MAXM];
    private static int [] next=new int[MAXM];
    private static int [] weight=new int[MAXM];
    private static int cnt;

    private static int [][] heap=new int[MAXN][2];
    private static int heapSize;
    private static int [] where=new int[MAXN];
    private static int nodeCnt;
    
    public static void build(){
        Arrays.fill(head,1,n+1,0);
        Arrays.fill(where,1,n+1,-1);
        heapSize=0;
        cnt=1;
    }

    public static void addEdge(int u,int v,int w){
        next[cnt]=head[u];
        to[cnt]=v;
        weight[cnt]=w;
        head[u]=cnt++;
    }

    public static void swap(int i,int j){
        int a=heap[i][0],b=heap[j][0];
        where[a]=j;
        where[b]=i;
        int[] tmp=heap[i];
        heap[i]=heap[j];
        heap[j]=tmp;
    }

    public static void addOrUpdate(int i){
        int v=to[i],w=weight[i];
        if (where[v]==-1){
            heap[heapSize][0]=v;
            heap[heapSize][1]=w;
            where[v]=heapSize++;
            heapInsert(where[v]);
        } else if (where[v]>=0) {
            heap[where[v]][1]=Math.min(heap[where[v]][1],w);
            heapInsert(where[v]);
        }
    }


    public static void heapInsert(int i){
        while (i>0 && heap[i][1]<heap[(i-1)/2][1]){
            swap(i,(i-1)/2);
            i=(i-1)/2;
        }
    }

    public static boolean isEmpty(){
        return heapSize==0;
    }

    public static int[] pop(){
        int [] edge=heap[0];
        swap(0,--heapSize);
        heapify(0);
        where[edge[0]]=-2;
        nodeCnt++;
        return edge;
    }

    public static void heapify(int i){
        int l=i*2+1;
        while (l<heapSize){
            int best=l+1 < heapSize ? heap[l][1]<heap[l+1][1] ? l : l+1 : l;
            best=heap[best][1]<heap[i][1] ? best : i;
            if (best==i){
                break;
            }
            swap(best,i);
            i=best;
            l=i*2+1;
        }
    }

    public static int prim(){
        int ans=0;
        where[1]=-2;
        nodeCnt=1;
        for (int ei = head[1]; ei > 0; ei=next[ei]) {
            addOrUpdate(ei);
        }
        while (!isEmpty()){
            int[] edge = pop();
            int nxt = edge[0];
            int cost = edge[1];
            ans+=cost;
            for (int ei = head[nxt]; ei >0 ; ei=next[ei]) {
                addOrUpdate(ei);
            }
        }
        return ans;
    }
    public static void main(String [] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(bf);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            in.nextToken();
            m=(int) in.nval;
            build();
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int u=(int)in.nval;
                in.nextToken();
                int v=(int) in.nval;
                in.nextToken();
                int w=(int) in.nval;
                addEdge(u,v,w);
                addEdge(v,u,w);
            }
            int ans=prim();
            out.println(nodeCnt==n ? ans : "orz");
        }
        out.flush();
        out.close();
        bf.close();
    }
}

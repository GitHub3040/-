import java.io.*;
import java.util.Arrays;

public class FlightPath {
    private static int n,m,k,s,t;
    private static int MAXN=10001;
    private static int MAXM=100001;
    private static int MAXK=11;
    private static int[] head=new int[MAXN];
    private static int[] to=new int[MAXM];
    private static int[] next=new int[MAXM];
    private static int[] weight=new int[MAXM];
    private static int cnt;

    private static int[][] heap=new int[MAXM*MAXK][3];
    private static int heapSize;
    private static int[][] distances=new int[MAXN][MAXK];

    public static void heapInsert(int u,int v,int w){
        heap[heapSize][0]=u;
        heap[heapSize][1]=v;
        heap[heapSize][2]=w;
        int i=heapSize++;
        while (i>0 && heap[i][2]<heap[(i-1)/2][2]){
            swap(i,(i-1)/2);
            i=(i-1)/2;
        }
    }

    private static int v,use,cost;
    public static void heapPop(){
        v=heap[0][0];
        use=heap[0][1];
        cost=heap[0][2];
        swap(0,--heapSize);
        heapify(0);
    }

    public static void heapify(int i){
        int l = i * 2 + 1;
        while (l < heapSize) {
            int best = l + 1 < heapSize && heap[l + 1][2] < heap[l][2] ? l + 1 : l;
            best = heap[best][2] < heap[i][2] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            l = i * 2 + 1;
        }
    }
    public static void swap(int i,int j){
        int[] tmp=heap[i];
        heap[i]=heap[j];
        heap[j]=tmp;
    }

    public static boolean isEmpty(){
        return heapSize==0;
    }

    public static void build(){
        cnt = 1;
        heapSize=0;
        for (int i = 0; i < n; i++) {
            head[i] = 0;
            for (int j = 0; j <= k; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        distances[s][0]=0;
    }

    private static void addEdge(int u,int v,int w){
        next[cnt]=head[u];
        to[cnt]=v;
        weight[cnt]=w;
        head[u]=cnt++;
    }

    public static int computeAlldistances(){
        heapInsert(s,0,0);
        while (!isEmpty()){
            heapPop();
            int currentDist = distances[v][use];
            if (currentDist < cost) continue;
            if (v==t){
                return cost;
            }
            for (int ei = head[v]; ei >0 ; ei=next[ei]) {
                int nxt=to[ei],w=weight[ei];
                if (use<k && distances[nxt][use+1]>cost){
                    distances[nxt][use+1]=cost;
                    heapInsert(nxt,use+1,cost);
                }
                if (distances[nxt][use]>cost+w){
                    distances[nxt][use]=cost+w;
                    heapInsert(nxt,use,cost+w);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(bf);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            in.nextToken();
            m=(int) in.nval;
            in.nextToken();
            k=(int) in.nval;
            in.nextToken();
            s=(int) in.nval;
            in.nextToken();
            t=(int) in.nval;
            build();
            for (int i = 0,u,v,w; i < m; i++) {
                in.nextToken();u=(int) in.nval;
                in.nextToken();v=(int) in.nval;
                in.nextToken();w=(int) in.nval;
                addEdge(u,v,w);
                addEdge(v,u,w);
            }
            out.println(computeAlldistances());
        }
        out.flush();
        out.close();
        bf.close();
    }
}

import java.io.*;
import java.util.Arrays;

public class DijkstraLuogu {
    public static int MAXN=100001;
    public static int MAXM=200001;
    public static int[] head=new int[MAXN];
    public static int[] next=new int[MAXM];
    public static int[] to=new int[MAXM];
    public static int[] weight=new int[MAXM];
    public static int cnt;
    public static int[] heap=new int[MAXN];
    public static int[] where=new int[MAXN];
    public static int[] distance=new int[MAXN];
    public static int size;
    public static int n,m,s;

    public static boolean isEmpty(){
        return size==0;
    }

    public static void addOrIgnore(int u,int w){
        if (where[u]==-2){
            heap[size]=u;
            where[u]=size++;
            distance[u]=w;
            heapInsert(where[u]);
        }else if (where[u]>=0) {
            distance[u]=Math.min(distance[u],w);
            heapInsert(where[u]);
        }
    }

    public static void heapInsert(int i){
        while (distance[heap[i]]<distance[heap[(i-1)/2]]){
            swap(i,(i-1)/2);
            i=(i-1)/2;
        }
    }

    public static void swap(int i,int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
        where[heap[i]] = i;
        where[heap[j]] = j;
    }

    public static void build(){
        Arrays.fill(head,0,n+1,0);
        Arrays.fill(where,0,n+1,-2);
        Arrays.fill(distance,0,n+1,Integer.MAX_VALUE);
        cnt=1;
        size=0;
    }

    public static void addEdge(int u,int v,int w){
        next[cnt]=head[u];
        to[cnt]=v;
        weight[cnt]=w;
        head[u]=cnt++;
    }

    public static void heapify(int i){
        int l=i*2+1;
        while (l<size){
            int best= l+1<size && distance[heap[l]]>distance[heap[l+1]] ? l+1 : l;
            best=distance[heap[best]]< distance[heap[i]] ? best : i;
            if (best==i){
                break;
            }
            swap(best,i);
            i=best;
            l=i*2+1;
        }
    }

    public static int heappop(){
        int i=heap[0];
        swap(0,--size);
        heapify(0);
        where[i]=-1;
        return i;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            in.nextToken();
            m=(int) in.nval;
            in.nextToken();
            s=(int) in.nval;
            build();
            for (int i = 0,u,v,w; i < m; i++) {
                in.nextToken();u=(int) in.nval;
                in.nextToken();v=(int) in.nval;
                in.nextToken();w=(int) in.nval;
                addEdge(u,v,w);
            }
            addOrIgnore(s,0);
            while (!isEmpty()){
                int u=heappop();
                for (int ei = head[u]; ei > 0 ; ei=next[ei]) {
                    addOrIgnore(to[ei],distance[u]+weight[ei]);
                }
            }
            for (int i = 1; i < n; i++) {
                out.print(distance[i]+" ");
            }
            out.println(distance[n]);
        }
        out.flush();
        out.close();
        br.close();
    }
}

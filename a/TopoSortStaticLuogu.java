import java.io.*;
import java.util.Arrays;

public class TopoSortStaticLuogu {
    public static int MAXN = 100001;

    public static int MAXM = 100001;

    // 建图相关，链式前向星
    public static int[] head = new int[MAXN];

    public static int[] next = new int[MAXM];

    public static int[] to = new int[MAXM];

    public static int cnt;

    public static int[] indegree = new int[MAXN];

    public static int [] heap=new int[MAXM];

    public static int  size;
    // 收集拓扑排序的结果
    public static int[] ans = new int[MAXN];

    public static int n, m;

    public static void insert(int x){
        int i=size++;
        heap[i]=x;
        while (heap[i]<heap[(i-1)/2]){
            swap(i,(i-1)/2);
            i=(i-1)/2;
        }
    }

    public static void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public static int pop(){
        int ans=heap[0];
        heap[0]=heap[--size];
        int i=0;
        int l=1;
        while (l<size){
            int best= l+1 < size && heap[l+1] < heap[l] ? l+1 : l;
            best=heap[i]<heap[best] ? i : best;
            if (best==i){
                break;
            }
            swap(best,i);
            i=best;
            l=i*2+1;
        }
        return ans;
    }

    public static boolean isEmpty(){
        return size==0;
    }

    public static void build(){
        cnt=1;
        size=0;
        Arrays.fill(head,1,n+1,0);
        Arrays.fill(indegree, 0, n + 1, 0);
    }

    public static void addEdge(int f, int t) {
        next[cnt] = head[f];
        to[cnt] = t;
        head[f] = cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            build();
            for (int i = 0, from, to; i < m; i++) {
                in.nextToken();
                from = (int) in.nval;
                in.nextToken();
                to = (int) in.nval;
                addEdge(from, to);
                indegree[to]++;
            }
            toposort();
            for (int i = 0; i < n - 1; i++) {
                out.print(ans[i] + " ");
            }
            out.println(ans[n - 1]);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void toposort(){
        for (int i = 1; i <= n; i++) {
            if (indegree[i]==0){
                insert(i);
            }
        }
        int fill=0;
        while (!isEmpty()){
            int cur=pop();
            ans[fill++]=cur;
            for (int ei = head[cur]; ei != 0; ei = next[ei]) {
                if (--indegree[to[ei]] == 0) {
                    insert(to[ei]);
                }
            }

        }
    }
}

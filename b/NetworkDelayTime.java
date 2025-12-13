import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times,int n,int k){
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ei:times) {
            graph.get(ei[0]).add(new int[]{ei[1],ei[2]});
        }
        int[] distance=new int[n+1];
        for (int i = 1; i <= n; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        distance[k]=0;
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        heap.add(new int[]{k,0});
        while (!heap.isEmpty()){
            int [] cur=heap.poll();
            int nxt=cur[0],dis=cur[1];
            if (distance[nxt]<cur[1]){
                continue;
            }
            for (int [] ei:graph.get(nxt)){
                if (dis+ei[1]<distance[ei[0]]){
                    distance[ei[0]]=dis+ei[1];
                    heap.add(new int[]{ei[0],dis+ei[1]});
                }
            }
        }
        int ans=0;
        for (int x:distance) {
            ans=Math.max(ans,x);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    public int networkDelayTime1(int[][] times,int n,int k){
        int INF=Integer.MAX_VALUE/2;
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ei:times) {
            graph.get(ei[0]-1).add(new int[]{ei[1]-1,ei[2]});
        }
        int[] distance=new int[n];
        for (int i = 0; i < n; i++) {
            distance[i]=INF;
        }
        int ans=0;
        distance[k-1]=0;
        boolean [] done=new boolean[n];
        while (true){
            int x=-1;
            for (int i = 0; i < n; i++) {
                if (!done[i] && (x<0 || distance[i]<distance[x])){
                    x=i;
                }
            }
            if (x==-1){
                return ans;
            }
            if (distance[x]==INF){
                return -1;
            }
            done[x]=true;
            ans=distance[x];
            for (int [] ei:graph.get(x)) {
                distance[ei[0]]=Math.min(distance[ei[0]],distance[x]+ei[1]);
            }
        }
    }
    public static int MAXN=101;
    public static int MAXM=6001;
    public static int[] head=new int[MAXN];
    public static int[] next=new int[MAXM];
    public static int[] to=new int[MAXM];
    public static int[] weight=new int[MAXM];
    public static int cnt;
    public static int[] heap=new int[MAXN];
    public static int[] where=new int[MAXN];
    public static int[] distance=new int[MAXN];
    public static int size;

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
        int tmp=i;
        where[heap[i]]=j;
        where[heap[j]]=tmp;
        tmp=heap[i];
        heap[i]=heap[j];
        heap[j]=tmp;
    }

    public static void build(int n){
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
    public int networkDelayTime2(int[][] times,int n,int k){
        build(n);
        for (int[] time:times) {
            addEdge(time[0],time[1],time[2]);
        }
        addOrIgnore(k,0);
        while (!isEmpty()){
            int u=heappop();
            for (int ei = head[u]; ei >0 ; ei=next[ei]) {
                addOrIgnore(to[ei],weight[ei]+distance[u]);
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if (distance[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,distance[i]);
        }
        return ans;
    }

}

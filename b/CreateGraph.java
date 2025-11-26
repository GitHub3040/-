import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateGraph {
    public static int MAXN=11;
    public static int MAXM=21;
//    邻接矩阵
    public static int[][] graph1=new int[MAXN][MAXN];
//    邻接表
    public static List<List<int []>> graph2=new ArrayList<>();
//    链式前缀星
    public static int [] head=new int[MAXN];
    public static int [] next=new int[MAXM];
    public static int[] to=new int[MAXM];
    public static int[] weight = new int[MAXM];
    public static int cnt;

    public static void build(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                graph1[i][j]=0;
            }
        }
        graph2.clear();
        for (int i = 0; i <= n; i++) {
            graph2.add(new ArrayList<>());
        }
        Arrays.fill(head,1,n+1,0);
        cnt=1;
    }

    public static void addEdge(int u,int v,int w){
        next[cnt]=head[u];
        to[cnt]=v;
        weight[cnt]=w;
        head[u]=cnt++;
    }
    
    public static void directGraph(int[][] graph){
        int n=graph.length;
//        邻接矩阵
        for (int i = 0; i < n; i++) {
            graph1[graph[i][0]][graph[i][1]]=graph[i][2];
        }
//        邻接表
        for (int i = 0; i < n; i++) {
            graph2.get(graph[i][0]).add(new int []{graph[i][1],graph[i][2]});
        }
//        链式前缀星
        for (int i = 0; i < n; i++) {
            addEdge(graph[i][0],graph[i][1],graph[i][2]);
        }
    }
    public static void undirectGraph(int[][] edges) {
        // 邻接矩阵建图
        for (int[] edge : edges) {
            graph1[edge[0]][edge[1]] = edge[2];
            graph1[edge[1]][edge[0]] = edge[2];
        }
        // 邻接表建图
        for (int[] edge : edges) {
            // graph2.get(edge[0]).add(edge[1]);
            // graph2.get(edge[1]).add(edge[0]);
            graph2.get(edge[0]).add(new int[] { edge[1], edge[2] });
            graph2.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        // 链式前向星建图
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
            addEdge(edge[1], edge[0], edge[2]);
        }
    }

    public static void traversal(int n) {
        System.out.println("邻接矩阵遍历 :");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(graph1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("邻接表遍历 :");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "(邻居、边权) : ");
            for (int[] edge : graph2.get(i)) {
                System.out.print("(" + edge[0] + "," + edge[1] + ") ");
            }
            System.out.println();
        }
        System.out.println("链式前向星 :");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "(邻居、边权) : ");
            // 注意这个for循环，链式前向星的方式遍历
            for (int ei = head[i]; ei > 0; ei = next[ei]) {
                System.out.print("(" + to[ei] + "," + weight[ei] + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 理解了带权图的建立过程，也就理解了不带权图
        // 点的编号为1...n
        // 例子1自己画一下图，有向带权图，然后打印结果
        int n1 = 4;
        int[][] edges1 = { { 1, 3, 6 }, { 4, 3, 4 }, { 2, 4, 2 }, { 1, 2, 7 }, { 2, 3, 5 }, { 3, 1, 1 } };
        build(n1);
        directGraph(edges1);
        traversal(n1);
        System.out.println("==============================");
        // 例子2自己画一下图，无向带权图，然后打印结果
        int n2 = 5;
        int[][] edges2 = { { 3, 5, 4 }, { 4, 1, 1 }, { 3, 4, 2 }, { 5, 2, 4 }, { 2, 3, 7 }, { 1, 5, 5 }, { 4, 2, 6 } };
        build(n2);
        undirectGraph(edges2);
        traversal(n2);
    }
}

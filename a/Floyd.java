import java.io.*;

public class Floyd {
    public static int MAXN = 101;

    public static int MAXM = 10001;

    public static int[] path = new int[MAXM];

    public static int[][] distance = new int[MAXN][MAXN];

    public static int n, m, ans;

    // 初始时设置任意两点之间的最短距离为无穷大，表示任何路不存在
    public static void build() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            in.nextToken();
            m=(int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                path[i]=(int) in.nval-1;
            }
            build();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    in.nextToken();
                    distance[i][j]=(int) in.nval;
                }
            }
            floyd();
            int ans=0;
            for (int i = 1; i < m; i++) {
                ans+=distance[path[i-1]][path[i]];
            }
            out.println(ans);
        }
        out.flush();
        out.close();
        br.close();
    }

    public static void floyd() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (distance[j][i]!=Integer.MAX_VALUE && distance[i][k]!=Integer.MAX_VALUE
                            && distance[j][i] + distance[i][k] < distance[j][k]) {
                        distance[j][k]= distance[j][i]+distance[i][k];
                    }
                }
            }
        }
    }
}

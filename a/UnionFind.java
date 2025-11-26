import java.io.*;

public class UnionFind {
    private static int MAXN=1000001;
    private static int[] father=new int[MAXN];
    private static int[] size=new int[MAXN];
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out =new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            build();
            in.nextToken();
            int m=(int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int op=(int) in.nval;in.nextToken();
                int x=(int) in.nval;in.nextToken();
                int y=(int) in.nval;
                if (op==1){
                    out.println(isSameFather(x,y) ? "Yes" : "No");
                }else {
                    union(x,y);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void build() {
        for (int i = 0; i <= n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public static int findFa(int x){
        if (father[x]!=x){
            father[x]=findFa(father[x]);
        }
        return father[x];
    }

    public static boolean isSameFather(int x,int y){
        int fx=findFa(x);
        int fy=findFa(y);
        return fx==fy;
    }

    public static void union(int x,int y){
        int fx=findFa(x);
        int fy=findFa(y);
        if (fx!=fy){
            if (size[fx]>size[fy]){
                father[fy]=fx;
                size[fx]+=size[fy];
            }else {
                father[fx]=fy;
                size[fy]+=size[fx];
            }
        }
    }
}

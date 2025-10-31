import java.io.*;

public class DiffMatrixLuogu{
    private static int MAXN=1002;
    private static int[][] arr=new int[MAXN][MAXN];
    private static int m,n;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            in.nextToken();
            m=(int) in.nval;
            for (int i = 0,a,b,c,d; i < m; i++) {
                in.nextToken();a=(int) in.nval;
                in.nextToken();b=(int) in.nval;
                in.nextToken();c=(int) in.nval;
                in.nextToken();d=(int) in.nval;
                add(a,b,c,d);
            }
            build();
            for (int i = 1; i <= n; i++) {
                out.print(arr[i][1]);
                for (int j = 2; j <= n; j++) {
                    out.print(" " + arr[i][j]);
                }
                out.println();
            }
            clear();
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void build(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j]+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }
    }
    public static void add(int a,int b,int c,int d){
        arr[a][b]+=1;
        arr[a][d+1]-=1;
        arr[c+1][b]-=1;
        arr[c+1][d+1]+=1;
    }
    public static void clear() {
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                arr[i][j] = 0;
            }
        }
    }


}

import java.io.*;

public class WaterLuogu {
    private static int MAXN=1000001;
    private static int off=30001;
    private static int m;
    private static int [] sum=new int[off+MAXN+off];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            int n=(int) in.nval;
            in.nextToken();
            m=(int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();int  v = (int) in.nval;
                in.nextToken();int x = (int) in.nval;
                fall(v,x);
            }
            build();
            int start = off + 1;
            out.print(sum[start++]);
            for (int i = 2; i <= m; i++) {
                out.print(" " + sum[start++]);
            }
            out.println();
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void fall(int v,int x){
        add(x-3*v+1,x-2*v,1,v,1);
        add(x-2*v+1,x,v-1,-v,-1);
        add(x+1,x+2*v,-v+1,v,1);
        add(x+2*v+1,x+3*v-1,v-1,1,-1);
    }
    public static void add(int l,int r,int s ,int e,int d){
        sum[l+off]+=s;
        sum[l+off+1]+=d-s;
        sum[r+off+1]-=e+d;
        sum[r+off+2]+=e;
    }
    public static void build(){
        for (int i = 1; i <= m+off; i++) {
            sum[i]+=sum[i-1];
        }
        for (int i = 1; i <= m+off ; i++) {
            sum[i]+=sum[i-1];
        }
    }
}

import java.io.*;
import java.util.Arrays;

public class Kruskal {
    private static int M,N;
    private static int MAXN=5001;
    private static int MAXM=200001;
    private static int [][] arr=new int[MAXM][3];
    private static int [] father=new int[MAXN];
    public static void main(String [] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            N=(int) in.nval;
            in.nextToken();
            M =(int) in.nval;
            for (int i = 0; i < M; i++) {
                in.nextToken();
                arr[i][0]=(int) in.nval;
                in.nextToken();
                arr[i][1]=(int) in.nval;
                in.nextToken();
                arr[i][2]=(int) in.nval;
            }
            build();
            Arrays.sort(arr,0,M,(a,b)->a[2]-b[2]);
            int ans=0,cnt=0;
            for (int i=0;i<M;i++) {
                if (union(arr[i][0],arr[i][1])) {
                    ans+=arr[i][2];
                    cnt++;
                }
            }
            out.println(cnt==N-1 ? ans: "orz");
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void build(){
        for (int i = 0; i <= N; i++) {
            father[i]=i;
        }
    }

    public static int find(int x){
        if (father[x]!=x){
            father[x]=find(father[x]);
        }
        return father[x];
    }

    public static boolean union(int x,int z){
        int fx=find(x);
        int fy=find(z);
        if (fx!=fy){
            father[fy]=fx;
            return true;
        }else {
            return false;
        }
    }
}

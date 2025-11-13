import java.io.*;

public class LeftRightLess {
    private static int MAXN=1000001;
    private static int [] arr=new int[MAXN];
    private static int n;
    private static int[][] ans = new int[MAXN][2];
    private static int[] stack=new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            compute();
            for (int i = 0; i < n; i++) {
                out.println(ans[i][0] + " " + ans[i][1]);
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void compute(){
        int r=0;
        for (int i = 0; i < n; i++) {
            while (r>0 && arr[stack[r-1]]>=arr[i]){
                int c=stack[--r];
                ans[c][0]=r>0 ? stack[r-1] : -1;
                ans[c][1]=i;
            }
            stack[r++]=i;
        }
        while (r>0){
            int c=stack[--r];
            ans[c][0]=r>0 ? stack[r-1] : -1;
            ans[c][1]=-1;
        }
        for (int i = n-2; i >= 0; i--) {
            if (ans[i][1]!=-1 && arr[ans[i][1]]==arr[i]){
                ans[i][1]=ans[ans[i][1]][1];
            }
        }
    }
}

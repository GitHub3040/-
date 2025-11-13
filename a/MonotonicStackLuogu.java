import java.io.*;

public class MonotonicStackLuogu {
    private static int MAXN = 3000001;
    private static int [] arr=new int[MAXN];
    private static int[] stack=new int[MAXN];
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n=(int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i]=(int) in.nval;
        }
        compute();
        for (int i = 0; i < n-1; i++) {
            out.print(arr[i]+" ");
        }
        out.println(arr[n-1]);
        out.flush();
        out.close();
        br.close();
    }
    public static void compute(){
        int r=0;
        for (int i = 0; i < n; i++) {
            while (r>0 && (arr[stack[r-1]]<arr[i])){
                int c=stack[--r];
                arr[c]=i+1;
            }
            stack[r++]=i;
        }
        while (r>0){
            int c=stack[--r];
            arr[c]=0;
        }
    }
}

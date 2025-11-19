import java.io.*;
import java.util.Arrays;

public class FlowerpotLuogu {
    private static int MAXN=1000001;
    private static int[][] arr=new int[MAXN][2];
    private static int n;
    private static int d;
    private static int[] max=new int[MAXN];
    private static int[] min=new int[MAXN];
    public static void main(String [] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!= StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            in.nextToken();
            d=(int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i][0]=(int) in.nval;
                in.nextToken();
                arr[i][1]=(int) in.nval;
            }
            int ans=compute();
            out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int compute(){
        Arrays.sort(arr,0,n,(a,b)->a[0]-b[0]);
        int r1=0,r2=0,l1=0,l2=0,l=0;
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            while (r1>l1 && arr[max[r1-1]][1]<=arr[i][1]){
                r1--;
            }
            while (r2>l2 && arr[min[r2-1]][1]>=arr[i][1]){
                r2--;
            }
            max[r1++]=i;
            min[r2++]=i;
            while ((arr[max[l1]][1]-arr[min[l2]][1]>=d)){
                ans=Math.min(ans,arr[i][0]-arr[l][0]);
                if (max[l1]==l){
                    l1++;
                }
                if (min[l2]==l){
                    l2++;
                }
                l++;
            }
        }
        return ans;
    }
}

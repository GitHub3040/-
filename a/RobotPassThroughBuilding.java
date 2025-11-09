import java.io.*;

public class RobotPassThroughBuilding {
    private static int MAXN=100001;
    private static int[] arr=new int[MAXN];
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            int l=0,r=0;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i]=(int) in.nval;
                r=Math.max(arr[i],r);
            }
            out.println(compute(l,r));
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int compute(int l,int r){
        int max=r;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if (check(mid,max)){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return r+1;
    }
    public static boolean check(int m,int max){
        for (int i = 0; i < n; i++) {
            if (m<arr[i]){
                m-=arr[i]-m;
            }else {
                m+=m-arr[i];
            }
            if (m<0){
                return false;
            }
            if (m>=max){
                return true;
            }
        }
        return true;
    }
}

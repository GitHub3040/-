import java.io.*;
import java.util.Arrays;

public class SnacksWaysBuyTickets {
    private static int N;
    private static long M;
    private static int MAXN=41;
    private static long[] free=new long[MAXN];
    private static int MAXM=1<<20;
    private static long[] left=new long[MAXM];
    private static long[] right=new long[MAXM];
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            N=(int) in.nval;
            in.nextToken();
            M=(long) in.nval;
            for (int i = 0; i < N; i++) {
                in.nextToken();
                free[i]=(long) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static long compute(){
        int lSize=f(0,N>>1,0,M,left,0);
        int rSize=f(N>>1,N,0,M,right,0);
        Arrays.sort(left,0,lSize);
        Arrays.sort(right,0,rSize);
        long ans=0;
        for (int i = lSize-1,j=0; i >=0 ; i--) {
            while (j<rSize &&  left[i]+right[j]<=M){
                j++;
            }
            ans+=j;
        }
        return ans;
    }
    public static int f(int i,int e,long s,long w,long[] arr,int j){
        if (s>w){
            return j;
        }
        if (i==e){
            arr[j++]=s;
        }else {
            j=f(i+1,e,s,w,arr,j);
            j=f(i+1,e,s+free[i],w,arr,j);
        }
        return j;
    }
}

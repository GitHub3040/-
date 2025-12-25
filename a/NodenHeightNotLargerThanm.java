import java.io.*;
import java.util.Arrays;

public class NodenHeightNotLargerThanm {
    private static int n,m;
    private static int N=51;
    private static int MOD=1_000_000_007;
    private static long [][] dp=new long[N][N];
    public static void build(){
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            in.nextToken();
            m=(int) in.nval;
            build();
            out.println(compute(n,m));
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int compute(int n,int m){
        if (n==0){
            return 1;
        }
        if (m==0){
            return 0;
        }
        if (dp[n][m]!=-1){
            return (int) dp[n][m];
        }
        long ans=0;
        for (int i = 0; i < n; i++) {
            long left = compute(i, m - 1);
            long right = compute(n - i - 1, m - 1);
            ans = (ans + left * right % MOD) % MOD;
        }
        dp[n][m]=ans;
        return (int) ans;
    }
    private static long [][] dp2=new long[N][N];
    public static int compute2(int n,int m){
        for (int i = 0; i <= m; i++) {
            dp2[0][i]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp2[i][j]=0;
                for (int k = 0; k < i; k++) {
                    dp2[i][j]=(dp2[i][j]+dp2[k][j-1]*dp2[i-k-1][j-1]%MOD)%MOD;
                }
            }
        }
        return (int) dp2[n][m];
    }
    private static long [] dp3=new long[N];
    public static int compute3(int n,int m){
        dp3[0]=1;
        for (int i = 0; i < n; i++) {
            dp3[i]=0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >=1 ; j--) {
                dp3[j]=0;
                for (int k = 0; k < j; k++) {
                    dp3[j]=(dp3[j]+dp3[k]*dp3[j-k-1]%MOD)%MOD;
                }
            }
        }
        return (int) dp3[n];
    }
}

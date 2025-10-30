import java.io.*;

public class KillMonster {
    public static int MAXN = 11;

    public static int[] kill = new int[MAXN];

    public static int[] blood = new int[MAXN];


    public static void main(String [] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int t=(int) in.nval;
        for (int i = 0; i < t; i++) {
            in.nextToken();
            int n=(int) in.nval;
            in.nextToken();
            int m=(int) in.nval;
            for (int j = 0; j < n; j++) {
                in.nextToken();
                kill[j] = (int) in.nval;
                in.nextToken();
                blood[j] = (int) in.nval;
            }
            int ans=attack(n,0,m);
            out.println(ans==Integer.MAX_VALUE ? -1 : ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int attack(int n,int i,int b){
        if (b<=0){
            return i;
        }
        if(i==n){
            return Integer.MAX_VALUE;
        }
        int ans=Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            swap(kill,blood,i,j);
            ans=Math.min(attack(n,i+1,b-(b>blood[i] ? kill[i] : kill[i]*2)),ans);
            swap(kill,blood,i,j);
        }
        return ans;
    }
    public static void swap(int[] kill,int[] blood,int i,int j){
        int tem=kill[i];
        kill[i]=kill[j];
        kill[j]=tem;
        tem=blood[i];
        blood[i]=blood[j];
        blood[j]=tem;
    }
}

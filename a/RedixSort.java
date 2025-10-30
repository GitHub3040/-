import java.io.*;
import java.util.Arrays;

public class RedixSort {
    private static int MAX=100001;
    private static int [] arr=new int[MAX];
    private static int [] help=new int[MAX];
    private static int n;
    private static int base=10;
    public static int[] cnts = new int[base];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n=(int) in.nval;
        in.nextToken();
        for (int i = 0; i < n; i++) {
            arr[i]=(int) in.nval;
            in.nextToken();
        }
        sort();
        for (int i = 0; i < n ; i++) {
            out.print(arr[i]+" ");
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int getMaxLen(int c){
        int ans=0;
        while (c>0){
            ans++;
            c/=base;
        }
        return ans;
    }
    public static void sort(){
        int min=arr[0];
        for (int i = 0; i < n; i++) {
            min=Math.min(min,arr[i]);
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            arr[i]-=min;
            max=Math.max(arr[i],max);
        }
        redixSort(getMaxLen(max));
        for (int i = 0; i < n; i++) {
            arr[i]+=min;
        }
    }
    public static void redixSort(int bits){
        for (int i = 1; bits>0; i*=base,bits--) {
            Arrays.fill(cnts,0);
            for (int j = 0; j < n; j++) {
                int x=(arr[j]/i)%base;
                cnts[x]++;
            }
            for (int j = 1; j < base; j++) {
                cnts[j]+=cnts[j-1];
            }
            for (int j = n-1; j>=0; j--) {
                help[--cnts[arr[j]/i%base]]=arr[j];
            }
            for (int j = 0; j < n; j++) {
                arr[j]=help[j];
            }
        }
    }
}

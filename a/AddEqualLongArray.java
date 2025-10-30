import java.io.*;
import java.util.HashMap;

public class AddEqualLongArray {
    private static int n;
    private static int [] arr;
    public static void main(String [] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(bf);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int) in.nval;
            arr=new int[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i]=(int) in.nval;
                if (arr[i] > 0) {
                    arr[i]=1;
                } else if (arr[i] < 0) {
                    arr[i]=-1;
                }
            }
            int ans=f();
            out.println(ans);
        }
        out.flush();
        out.close();
        bf.close();
    }
    public static int f(){
        int sum=0;
        HashMap <Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int ans=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if (map.containsKey(-sum)){
                ans=Math.max(ans,i-map.get(-sum));
            }
            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }
        }
        return ans;
    }
}

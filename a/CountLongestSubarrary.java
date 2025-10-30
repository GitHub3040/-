import java.io.*;
import java.util.HashMap;

public class CountLongestSubarrary {
    private static int n;
    private static int MAXN=100001;
    private static int aim;
    private static int[] arr=new int[MAXN];
    private static HashMap<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(bf);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            aim = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        bf.close();
    }
    public static int compute(){
        map.clear();
        map.put(0,-1);
        int ans=0;
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if (map.containsKey(sum-aim)){
                ans=Math.max(ans,i-map.get(sum-aim));
            }
            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }
        }
        return ans;
    }
}

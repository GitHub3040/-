import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCover {
    private static int MAX=10001;
    private static int n;
    private static int[][] arr=new int[MAX][MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(bf);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        in.nextToken();
        n=(int) in.nval;
        in.nextToken();
        for (int i = 0; i < n; i++) {
            arr[i][0]=(int) in.nval;
            in.nextToken();
            arr[i][1]=(int) in.nval;
            in.nextToken();
        }
        int ans=count();
        out.println(ans);
        out.flush();
        out.close();
        bf.close();
    }
    public static int count(){
        Arrays.sort(arr,0,n,(a,b)->
            a[0]-b[0]);

        int ans=0;
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>((a,b)->a-b);
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && heap.peek()<=arr[i][0]){
                heap.poll();
            }
            heap.add(arr[i][1]);
            ans=Math.max(ans, heap.size());
        }
        return ans;
    }
}

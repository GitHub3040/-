import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {
    public static void main(String [] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF) {
            ArrayList<ArrayList<int []>> graph =new ArrayList<>();
            int N = (int) in.nval;
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            in.nextToken();
            int M = (int) in.nval;
            for (int i = 0,u,v,w; i < M; i++) {
                in.nextToken();
                u = (int) in.nval;
                in.nextToken();
                v = (int) in.nval;
                in.nextToken();
                w = (int) in.nval;
                graph.get(u).add(new int[]{v,w});
                graph.get(v).add(new int[]{u,w});
            }
            PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->a[1]-b[1]);
            for (int[] edge:graph.get(1)){
                heap.add(edge);
            }
            boolean [] sets=new boolean[N+1];
            int ans=0;
            int cnt=1;
            sets[1]=true;
            while (!heap.isEmpty()){
                int[] edge = heap.poll();
                int next = edge[0];
                int cost = edge[1];
                if (!sets[next]){
                    cnt++;
                    ans+=cost;
                    sets[next]=true;
                    for (int [] e: graph.get(next)) {
                        heap.add(e);
                    }
                }
            }
            out.println(cnt==N ? ans : "orz");
        }
        out.flush();
        out.close();
        br.close();
    }

}

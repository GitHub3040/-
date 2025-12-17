import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TreeMap;

public class ElectricCarPlan {
    public int electricCarPlan(int[][] paths,int cnt,int start,int end,int[] charge){
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int n=charge.length;
        int[][] distances=new int[n][cnt+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= cnt; j++) {
                distances[i][j]=Integer.MAX_VALUE;
            }
        }
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ei:paths) {
            graph.get(ei[0]).add(new int[]{ei[1],ei[2]});
            graph.get(ei[1]).add(new int[]{ei[0],ei[2]});
        }
        boolean [][] visited=new boolean[n][cnt+1];
        distances[start][0]=0;
        heap.add(new int[]{start,0,0});
        while (!heap.isEmpty()){
            int [] cur=heap.poll();
            int u=cur[0],ele=cur[1],t=cur[2];
            if (u==end){
                return t;
            }
            if (visited[u][ele]){
                continue;
            }
            visited[u][ele]=true;
            if (ele<cnt){
                if (!visited[u][ele+1] && t+charge[u]<distances[u][ele+1]){
                    heap.add(new int[]{u,ele+1,t+charge[u]});
                }
            }
            for (int[] ei:graph.get(u)) {
                int nextPower=ele-ei[1];
                int newCost=t+ei[1];
                if (nextPower>=0 && !visited[ei[0]][nextPower] && newCost<distances[ei[0]][nextPower]){
                    distances[ei[0]][nextPower]=newCost;
                    heap.add(new int[]{ei[0],nextPower,newCost});
                }
            }
        }
        return -1;
    }
}

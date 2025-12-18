import java.util.Arrays;

public class FindCheapestPrice {
    public int findCheapestPrice(int n,int[][] flight,int src,int dst,int k){
        int [] distance=new int[n];
        for (int i = 0; i < n; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        for (int i = 0; i < k; i++) {
            int [] nxt= Arrays.copyOf(distance,n);
            for (int [] cur:flight) {
                int u=cur[0],v=cur[1],w=cur[2];
                if (nxt[u]!=Integer.MAX_VALUE && nxt[u]+w<distance[v]){
                    distance[v]=nxt[u]+w;
                }
            }
        }
        return distance[dst]==Integer.MAX_VALUE ? -1 : distance[dst];
    }
}

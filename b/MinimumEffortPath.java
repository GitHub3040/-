import java.util.PriorityQueue;

public class MinimumEffortPath {
    public int minimumEffortPath(int[][] height){
        int m=height.length;
        int n=height[0].length;
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->a[2]-b[2]);
        heap.add(new int[]{0,0,0});
        int[] move=new int[]{-1,0,1,0,-1};
        int[][] distance=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=0;
        while (!heap.isEmpty()){
            int[] cur=heap.poll();
            int x=cur[0],y=cur[1],mx=cur[2];
            if (distance[x][y]<mx){
                continue;
            }
            if (x==m-1 && y==n-1){
                return mx;
            }
            for (int k = 0; k < 4; k++) {
                int dx=move[k]+x,dy=move[k+1]+y;
                if (dx>=0 && dx<m && dy>=0 && dy<n){
                    int newEffort = Math.max(mx, Math.abs(height[x][y] - height[dx][dy]));
                    if (newEffort < distance[dx][dy]) {
                        distance[dx][dy] = newEffort;
                        heap.offer(new int[]{dx, dy, newEffort});
                    }
                }
            }
        }
        return distance[m-1][n-1];
    }
}

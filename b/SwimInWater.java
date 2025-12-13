import java.util.PriorityQueue;

public class SwimInWater {
    public int swimInWater(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int[][] distance=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=grid[0][0];
        int[] move=new int[]{-1,0,1,0,-1};
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->a[2]-b[2]);
        heap.add(new int[]{0,0,grid[0][0]});
        while (!heap.isEmpty()){
            int [] cur=heap.poll();
            int x=cur[0],y=cur[1],t=cur[2];
            if (t>distance[x][y]){
                continue;
            }
            if (x==m-1 && y==n-1){
                return t;
            }
            for (int i = 0; i < 4; i++) {
                int dx=move[i]+x,dy=move[i+1]+y;
                if (dx>=0 && dx<m && dy>=0 && dy<n){
                    int newTime=Math.max(t,grid[dx][dy]);
                    if (distance[dx][dy]>newTime){
                        distance[dx][dy]=newTime;
                        heap.add(new int[]{dx,dy,newTime});
                    }
                }
            }
        }
        return distance[m-1][n-1];
    }
}

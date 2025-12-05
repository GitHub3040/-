import java.util.ArrayDeque;

public class MinimumObstacles {
    public int minimumObstacles(int [][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int [][] distance=new int[m][n];
        int [] move=new int[]{-1,0,1,0,-1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[] { 0, 0 });
        while (!queue.isEmpty()){
            int [] record=queue.pollFirst();
            int x=record[0],y=record[1];
            if (x == m - 1 && y == n - 1) {
                return distance[x][y];
            }
            for (int i = 0,dx,dy; i < 4; i++) {
                dx=x+move[i];
                dy=y+move[i+1];
                if (dx>=0 && dx<m && dy>=0 && dy<n && distance[x][y]+grid[dx][dy]<distance[dx][dy]){
                    if (grid[dx][dy]==1){
                        queue.addLast(new int[]{dx,dy});
                    }else {
                        queue.addFirst(new int[]{dx,dy});
                    }
                    distance[dx][dy]=distance[x][y]+grid[dx][dy];
                }
            }
        }
        return -1;
    }
}

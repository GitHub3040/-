import java.util.ArrayDeque;

public class MinCost {
    public int minCost(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int [][] distance=new int[m][n];
        int[][] move = { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
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
            for (int i = 1; i <= 4 ; i++) {
                int dx=x+move[i][0],dy=y+move[i][1];
                int weight=grid[x][y]!=i ? 1 : 0;
                if (dx>=0 && dx<m && dy>=0 && dy<n && distance[x][y]+weight<distance[dx][dy]) {
                    distance[dx][dy] = distance[x][y] + weight;
                    if (weight == 1) {
                        queue.addLast(new int[]{dx, dy});
                    } else {
                        queue.addFirst(new int[]{dx, dy});
                    }
                }

            }

        }
        return 0;
    }
}

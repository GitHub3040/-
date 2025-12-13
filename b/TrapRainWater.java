import java.util.PriorityQueue;

public class TrapRainWater {
    public int trapRainWater(int[][] heightMap){
        int m=heightMap.length;
        int n=heightMap[0].length;
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        boolean[][] visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    // 边界
                    heap.add(new int[] { i, j, heightMap[i][j]});
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        int [] move=new int[]{0,-1,0,1,0};
        int ans=0;
        while (!heap.isEmpty()){
            int [] cur=heap.poll();
            int x=cur[0],y=cur[1],h=cur[2];
            ans+=h-heightMap[x][y];
            for (int i = 0,dx,dy; i < 4; i++) {
                dx=x+move[i];
                dy=y+move[i+1];
                if (dx>=0 && dx<m && dy>=0 && dy<n && !visited[dx][dy]){
                    heap.add(new int[]{dx,dy,Math.max(h,heightMap[dx][dy])});
                    visited[dx][dy]=true;
                }
            }
        }
        return ans;
    }
}

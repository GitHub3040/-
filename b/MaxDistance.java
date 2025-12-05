public class MaxDistance {
    public int maxDistance(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int [][] queue=new int[m*n][2];
        int l=0,r=0;
        int [] move=new int[]{-1,0,1,0,-1};
        int seas=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    queue[r][0]=i;
                    queue[r++][1]=j;
                }else {
                    seas++;
                }
            }
        }
        if ( seas== 0 || seas == n * m) {
            return -1;
        }
        int level=0;
        while (r>l){
            int size=r-l;
            level++;
            for (int i = 0; i < size; i++) {
                int x=queue[l][0];
                int y=queue[l++][1];
                for (int j = 0; j < 4; j++) {
                    int dx=x+move[j];
                    int dy=y+move[j+1];
                    if (dx>=0 && dx<m && dy>=0 && dy<n && grid[dx][dy]==0){
                        queue[r][0]=dx;
                        queue[r][1]=dy;
                        grid[dx][dy]=1;
                        r++;
                    }
                }
            }
        }
        return level-1;
    }
}

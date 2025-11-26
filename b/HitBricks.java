public class HitBricks {
    private static int m,n;
    private static int[][] grid;
    public int[] hitBricks(int[][] g,int[][] hits){
        m=g.length;
        n=g[0].length;
        grid=g;
        int hn=hits.length;
        int [] ans=new int[hn];
        if (m==1){
            return ans;
        }
        for (int[] x : hits) {
            grid[x[0]][x[1]]-=1;
        }
        for (int j=0;j<n;j++) {
            if (grid[0][j]==1){
                dfs(0,j);
            }
        }
        for (int i = hn-1; i >= 0 ; i--) {
            int x=hits[i][0];
            int y=hits[i][1];
            grid[x][y]+=1;
            if (worth(x,y)){
                ans[i]=dfs(x,y)-1;
            }
        }
        return ans;
    }
    public static int dfs(int i,int j){
        if (i<0 || j<0 || i>=m || j>=n || grid[i][j]!=1){
            return 0;
        }
        grid[i][j]=2;
        return 1+dfs(i+1,j)+dfs(i-1,j)+dfs(i,j+1)+dfs(i,j-1);
    }
    public static boolean worth(int i,int j){
        return grid[i][j] == 1 && (i == 0
                        || (i > 0 && grid[i - 1][j] == 2)
                        || (i < m - 1 && grid[i + 1][j] == 2)
                        || (j > 0 && grid[i][j - 1] == 2)
                        || (j < n - 1 && grid[i][j + 1] == 2));

    }
}

public class LargestIsland {
    private static int cnt;
    public int largestIsland(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        cnt=2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                   dfs(grid,m,n,i,j);
                   cnt++;
                }
            }
        }
        int ans=0;
        int[] size=new int[cnt];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]>1){
                    ans=Math.max(ans,++size[grid[i][j]]);
                }
            }
        }
        boolean[] visit=new boolean[cnt];
        for (int i = 0; i < cnt; i++) {
            visit[i]=false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0) {
                    int up = i > 0 ? grid[i - 1][j] : 0;
                    int down = i < m - 1 ? grid[i + 1][j] : 0;
                    int left = j > 0 ? grid[i][j - 1] : 0;
                    int right = j < n - 1 ? grid[i][j + 1] : 0;
                    visit[up] = true;
                    int sum = 1 + size[up];
                    if (!visit[down]) {
                        sum += size[down];
                        visit[down] = true;
                    }
                    if (!visit[left]) {
                        sum += size[left];
                        visit[left] = true;
                    }
                    if (!visit[right]) {
                        sum += size[right];
                        visit[right] = true;
                    }
                    ans = Math.max(ans, sum);
                    visit[up] = false;
                    visit[down] = false;
                    visit[left] = false;
                    visit[right] = false;
                }
            }
        }
        return ans;
    }
    public static void dfs(int[][] grid,int m,int n,int i,int j){
        if (i<0 || j<0 || i>=m || j>=n || grid[i][j]!=1){
            return ;
        }
        grid[i][j]=cnt;
        dfs(grid,m,n,i+1,j);
        dfs(grid,m,n,i-1,j);
        dfs(grid,m,n,i,j+1);
        dfs(grid,m,n,i,j-1);
    }
}

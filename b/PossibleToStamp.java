public class PossibleToStamp {
    private static int m,n;
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        m=grid.length;
        n=grid[0].length;
        int[][] sum=new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = grid[i][j];
            }
        }
        build(sum);
        int [][] g=new int[m+2][n+2];
        for (int i = 1,c=i+stampHeight-1; c <= m; i++,c++) {
            for (int j = 1,d=j+stampWidth-1; d <= n; j++,d++) {
                if (sumRegion(sum,i,j,c,d)==0){
                    add(g,i,j,c,d);
                }
            }
        }
        build(g);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if (grid[i][j]==0&&g[i+1][j+1]==0){
                    return false;
                }
            }
        }
        return true;
    }
    public static int sumRegion(int[][] sum,int a,int b,int c,int d){
        return sum[c][d]-sum[c][b-1]-sum[a-1][d]+sum[a-1][b-1];
    }
    public static void add(int[][] g,int a,int b,int c,int d){
        g[a][b]+=1;
        g[a][d+1]-=1;
        g[c+1][b]-=1;
        g[c+1][d+1]+=1;
    }
    public static void build(int[][] g){
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j]+=g[i-1][j]+g[i][j-1]-g[i-1][j-1];
            }
        }
    }
}

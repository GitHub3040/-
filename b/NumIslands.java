public class NumIslands {
    private static int MAXN=100001;
    private static int[] father=new int[MAXN];
    private static int[] size=new int[MAXN];
    private static int n,m;
    private static int cnt;
    public  int numIslands(char[][] grid){
        m=grid.length;
        n=grid[0].length;
        build(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    if (i>0 && grid[i-1][j]=='1'){
                        int x=index(i,j);
                        int y=index(i-1,j);
                        union(x,y);
                    }
                    if (j>0 && grid[i][j-1]=='1'){
                        int x=index(i,j);
                        int y=index(i,j-1);
                        union(x,y);
                    }
                }
            }
        }
        return cnt;
    }
    public static int index(int a,int b){
        return a*n+b;
    }
    public static void build(char[][] grid) {
        cnt=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int index = index(i,j);
                    father[index] = index;
                    cnt++;
                }

            }
        }
    }

    public static int findFa(int x){
        if (father[x]!=x){
            father[x]=findFa(father[x]);
        }
        return father[x];
    }

    public static void union(int x,int y){
        int fx=findFa(x);
        int fy=findFa(y);
        if (fx!=fy){
            if (size[fx]>size[fy]){
                father[fy]=fx;
                size[fx]+=size[fy];
            }else {
                father[fx]=fy;
                size[fy]+=size[fx];
            }
            cnt--;
        }
    }
    public int numIslands1(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    ans+=1;
                    f(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void f(char[][] grids,int i,int j){
        if (i<0 || j<0 || i>=grids.length || j>=grids[0].length || grids[i][j]!='1'){
            return ;
        }
        grids[i][j]=1;
        f(grids,i+1,j);
        f(grids,i-1,j);
        f(grids,i,j+1);
        f(grids,i,j-1);
    }
}

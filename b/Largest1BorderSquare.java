public class Largest1BorderSquare {
    public int largest1BorderSquare(int[][] grid){
        int ans=0;
        n=grid.length;
        m=grid[0].length;
        build(grid);
        if (sum(grid,0,0, n-1, m-1)==0){
            return 0;
        }
        ans=1;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                for (int k = ans+1,c=a+ans,d=b+ans; c<n&&d<m; k++,c++,d++) {
                    if (sum(grid,a,b,c,d)-sum(grid,a+1,b+1,c-1,d-1)==(k - 1) << 2){
                        ans=k;
                    }
                }
            }
        }
        return ans*ans;
    }
    private static int m,n;
    public void build(int[][] matrix){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]+=get(matrix,i-1,j)+get(matrix,i,j-1)-get(matrix,i-1,j-1);
            }
        }
    }
    public static int get(int [][] arr,int i,int j){
        return (i<0||j<0) ? 0 : arr[i][j];
    }
    public static int sum(int [][] arr,int a,int b,int c,int d){
        return a>c ? 0 : (arr[c][d]-get(arr,c,b-1)-get(arr,a-1,d)+get(arr,a-1,b-1));
    }
}

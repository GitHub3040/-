import java.util.Arrays;

public class MaximalRectangle {
    private static int MAXN=201;
    private static int[] height=new int[MAXN];
    private static int[] stack = new int[MAXN];
    private static int r;
    public int maximaxlRectangle(char[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        Arrays.fill(height,0,n,0);
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j]=matrix[i][j]=='0' ? 0 : height[j]+1;
            }
            ans=Math.max(ans,largestRectangleArea(n));
        }
        return ans;
    }
    public static int largestRectangleArea(int n){
        int r=0,ans=0;
        for (int i = 0; i < n; i++) {
            while (r>0 && height[stack[r-1]]>height[i]){
                int c=stack[--r];
                int left= r==0 ? -1 : stack[r-1];
                ans=Math.max(ans,(i-left-1)*height[c]);
            }
            stack[r++]=i;
        }
        while (r>0){
            int c=stack[--r];
            int left= r==0 ? -1 : stack[r-1];
            ans=Math.max(ans,(n-left-1)*height[c]);
        }
        return ans;
    }
}

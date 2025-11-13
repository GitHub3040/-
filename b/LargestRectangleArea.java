public class LargestRectangleArea {
    public int largestRectangleArea(int[] height){
        int n=height.length;
        int[] stack=new int[n];
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

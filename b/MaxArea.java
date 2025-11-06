public class MaxArea {
    public int maxArea(int [] height){
        int n=height.length;
        int l=0,r=n-1,ans=0;
        while (l<r){
            if (height[l]>height[r]){
                ans=Math.max(ans,(r-l)*height[r]);
                r--;
            }else {
                ans=Math.max(ans,(r-l)*height[l]);
                l++;
            }
        }
        return ans;
    }
}

public class FindMaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] point,int k){
        int n=point.length;
        int [] queue=new int[n];
        int r=0,l=0;
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x=point[i][0],y=point[i][1];
            while (r>l && x-point[queue[l]][0]>k){
                l++;
            }
            ans=Math.max(ans,r==l ? Integer.MIN_VALUE : y+point[queue[l]][1]+x-point[queue[l]][0]);
            while (r>l && y-x>=point[queue[r-1]][1]-point[queue[r-1]][0]){
                r--;
            }
            queue[r++]=i;
        }
        return ans;
    }
}

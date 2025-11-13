public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums){
        int n=nums.length;
        int [] stack=new int[n];
        int r=1,ans=0;
        for (int i = 1; i < n; i++) {
            if (r>0 && nums[stack[r-1]]>nums[i]){
                stack[r++]=i;
            }
        }
        for (int i = n-1; i > 0; i--) {
            while (r>0 && nums[stack[r-1]]<=nums[i]){
                ans=Math.max(ans,i-stack[--r]);
            }
        }
        return ans;
    }
}

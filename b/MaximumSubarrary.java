public class MaximumSubarrary {
    public int maxSubArray(int[] nums){
        int n=nums.length;
        int cur=nums[0];
        int ans=nums[0];
        for (int i = 1; i < n; i++) {
            cur=Math.max(nums[i-1],nums[i-1]+cur);
            ans=Math.max(ans,cur);
        }
        return ans  ;
    }
}

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0,ans=Integer.MAX_VALUE;
        int left=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum-nums[left]>=target){
                sum-=nums[left++];
            }
            if (sum>=target){
                ans=Math.min(ans,i-left+1);
            }
        }
        return ans>nums.length ? 0:ans;
    }
}

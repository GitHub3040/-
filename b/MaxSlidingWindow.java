public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums,int k){
        int n=nums.length;
        int[] queue=new int[n];
        int[] ans=new int[n-k+1];
        int r=0,l=0;
        for (int i = 0; i < k-1; i++) {
            while (r>l && nums[i]>=nums[queue[r-1]]){
                r--;
            }
            queue[r++]=i;
        }
        for (int i = 0; i < n-k+1; i++) {
            int c=i+k-1;
            while (r>l && nums[c]>=nums[queue[r-1]]){
                r--;
            }
            queue[r++]=c;
            ans[i]=nums[queue[l]];
            if (queue[l]==i){
                l++;
            }
        }
        return ans;
    }
}

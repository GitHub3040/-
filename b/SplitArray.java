public class SplitArray {
    public int splitArray(int[] nums,int k){
        long l=0,r=0;
        for (int num:nums){
            r+=num;
        }
        while (l<=r){
            long mid=(l+r)/2;
            if (check(mid,nums)<=k){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return (int)(r+1);
    }
    public static int check(long m,int[] nums){
        int ans=1;
        long cur=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>m){
                return Integer.MAX_VALUE;
            }
            if (cur+nums[i]>m){
                ans++;
                cur=nums[i];
            }
            else {
                cur+=nums[i];
            }
        }
        return ans;
    }
}


public class ShortestSubarray {
    public int shortestSubarray(int[] nums,int k){
        int n=nums.length;
        int[] queue=new int[n+1];
        long[] pre_sum=new long[n+1];
        for (int i = 0; i < n; i++) {
            pre_sum[i+1]=pre_sum[i]+nums[i];
        }
        int r=0,l=0;
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            while (r>l && pre_sum[i]-pre_sum[queue[l]]>=k){
                ans=Math.min(ans,i-queue[l]);
                l++;
            }
            while (r>l && pre_sum[i]<=pre_sum[queue[r-1]]){
                r--;
            }
            queue[r++]=i;
        }
        System.out.println(n);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}

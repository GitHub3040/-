public class LongestSubarray {
    public int longestSubarray(int[] nums,int limit){
        int n=nums.length;
        int[] max=new int[n];
        int[] min=new int[n];
        int r1=0,r2=0,l1=0,l2=0,l=0;
        int ans=0;
        for (int i = 0; i < n; i++) {
            while (r1>l1 && nums[max[r1-1]]<=nums[i]){
                r1--;
            }
            while (r2>l2 && nums[min[r2-1]]>=nums[i]){
                r2--;
            }
            max[r1++]=i;
            min[r2++]=i;
            while (nums[max[l1]]-nums[min[l2]]>limit){
                l++;
                if (max[l1]<l){
                    l1++;
                }
                if (min[l2]<l){
                    l2++;
                }
            }
            ans=Math.max(ans,i-l+1);
        }
        return ans;
    }
}

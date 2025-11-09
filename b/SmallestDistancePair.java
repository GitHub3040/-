import java.util.Arrays;

public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums,int k){
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        int l=0,r=nums[n-1]-nums[0],m,cnt;
        while (l<=r){
            m=l+((r-l)>>1);
            cnt=f(m,nums);
            if (cnt>=k){
                r=m-1;
            }else {
                l=m+1;
            }
        }
        return r+1;
    }
    public static int f(int m,int [] nums){
        int l=0,n=nums.length,ans=0;
        for (int i = 0; i < n; i++) {
            while (nums[i]-nums[l]>m){
                l++;
            }
            ans+=i-l;
        }
        return ans;
    }
}

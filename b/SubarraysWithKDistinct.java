import java.util.Arrays;

public class SubarraysWithKDistinct {
    private static int MAXN=20001;
    private static int[] arr=new int[MAXN];
    public int f(int[] nums, int k) {
        Arrays.fill(arr, 1, nums.length + 1, 0);
        int ans=0;
        for (int i = 0,l=0,collection=0; i < nums.length; i++) {
            if (++arr[nums[i]]==1){
                collection++;
            }
            while (collection>k){
                if (--arr[nums[l++]]==0){
                    collection--;
                }
            }
            ans+=i-l+1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k){
        return f(nums,k)-f(nums,k-1);
    }
}

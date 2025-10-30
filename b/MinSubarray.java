import java.util.Arrays;
import java.util.HashMap;

public class MinSubarray {
    public int minSubarray(int[] nums,int p){
        HashMap<Integer,Integer> map=new HashMap<>();
        int total=0;
        for (int num:nums) {
            total=(total+num)%p;
        }
        if (total%p==0){
            return 0;
        }
        map.put(0,-1);
        int ans=Integer.MAX_VALUE,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=(sum+nums[i])%p;
            int temp=(sum-total+p)%p;
            if (map.containsKey(temp)) {
                ans = Math.min(ans, i - map.get(temp));
            }
            map.put(sum,i);
        }
        return ans==nums.length ? -1:ans;
    }
}

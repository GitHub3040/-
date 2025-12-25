public class Rob {
    public int rob(int [] nums){
        int n=nums.length;
        int prepre=0,pre=nums[0];
        for (int i = 2,cur; i <= n; i++) {
           cur=Math.max(prepre+nums[i-1],pre);
           prepre=pre;
           pre=cur;
        }
        return pre;
    }
}

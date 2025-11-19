public class TotalSteps {
    public int totalSteps(int[] nums){
        int n=nums.length;
        int[][] stack=new int[n][2];
        int r=0,ans=0;
        for (int i = n-1,cur; i >=0 ; i--) {
            cur=0;
            while (r>0 && nums[i]>stack[r-1][0]){
                cur=Math.max(cur+1,stack[--r][1]);
            }
            stack[r][0]=nums[i];
            stack[r++][1]=cur;
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}

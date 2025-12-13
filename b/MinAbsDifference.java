import java.util.Arrays;

public class MinAbsDifference {
    private static int MAXM=1<<20;
    private static int[] lSum=new int[MAXM];
    private static int[] rSum=new int[MAXM];
    private static int ans;
    private static int fill;
    public int minAbsDifference(int [] nums,int goal){
        int n=nums.length;
        long min = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                max += nums[i];
            } else {
                min += nums[i];
            }
        }
        if (max < goal) {
            return (int) Math.abs(max - goal);
        }
        if (min > goal) {
            return (int) Math.abs(min - goal);
        }
        Arrays.sort(nums);
        ans=Integer.MAX_VALUE;
        fill=0;
        f(0,n>>1,0,lSum,nums);
        int lSize=fill;
        fill=0;
        f(n>>1,n,0,rSum,nums);
        int rSize=fill;
        Arrays.sort(lSum,0,lSize);
        Arrays.sort(rSum,0,rSize);
        for (int l = 0,r=rSize-1; l < lSize; l++) {
            while (r>0 && Math.abs(lSum[l]+rSum[r]-goal)>=Math.abs(lSum[l]+rSum[r-1]-goal)){
                r--;
            }
            ans=Math.min(ans,Math.abs(lSum[l]+rSum[r]-goal));
        }
        return  ans;
    }
    public static int find(int l,int r,long target){
        while (l<=r){
            int mid=l+(r-l)/2;
            if (rSum[mid]>=target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return r+1;
    }
    public static void f(int i,int e,int s,int[] arr,int [] nums){
        if (i==e){
            arr[fill++]=s;
        }else {
            int j=i+1;
            while (j<e && nums[i]==nums[j]){
                j++;
            }
            for (int k = 0; k <= j-i; k++) {
                f(j,e,s+k*nums[i],arr,nums);
            }
        }
    }
}

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        for (int odd=1,even=0;odd<n && even<n ;) {
            if ((nums[n-1]&1)==1){
                swap(nums,odd,n-1);
                odd+=2;
            }else {
                swap(nums,even,n-1);
                even+=2;
            }
        }
        return  nums;
    }
    public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

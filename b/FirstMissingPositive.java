public class FirstMissingPositive {
    public int firstMissingPositive(int [] nums){
        int n=nums.length;
        int l=0,r=n;
        while (l<r){
            if (nums[l]<=l){
                r--;
                swap(l,r,nums);
            }else if (nums[l]==l+1){
                l++;
            }else if (nums[l]>r || nums[nums[l]-1]==nums[l] ){
                r--;
                swap(l,r,nums);
            }else{
                swap(l,nums[l]-1,nums);
            }
        }
        return l+1;
    }
    public  void swap(int i,int j,int[] nums){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

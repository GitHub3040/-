public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int c=0;
        for(int num:nums){
            c^=num;
        }
        int x=c&-c;
        int a=0;
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            if((num&x)==num){
                a^=num;
            }
        }
        return new int [] {a,a^c};
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permute {
    private static List<List<Integer>> ans;
    public List<List<Integer>> permute(int [] nums){
        ans=new ArrayList<>();
        f(nums,0);
        return ans;
    }
    public List<List<Integer>> permuteUnique(int[] nums){
        ans=new ArrayList<>();
        f1(nums,0);
        return ans;
    }
    public void f1(int [] nums,int i){
        if (i==nums.length){
            List<Integer> copy=new ArrayList<>();
            for (int num:nums){
                copy.add(num);
            }
            ans.add(copy);
        }else {
            HashSet<Integer> set=new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])){
                    set.add(nums[j]);
                    swap(nums, i, j);
                    f1(nums, i + 1);
                    set.remove(nums[j]);
                    swap(nums, i, j);
                }
            }
        }
    }
    public void f(int[] nums,int i){
        if (i==nums.length){
            List<Integer> copy=new ArrayList<>();
            for (int num:nums){
                copy.add(num);
            }
            ans.add(copy);
        }
        for (int j=i;j<nums.length;j++){
            swap(nums,i,j);
            f(nums,i+1);
            swap(nums,i,j);
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

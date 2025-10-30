import config.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    private static List<List<Integer>> ans;
    public List<List<Integer>> subsetWithDup(int [] nums){
        Arrays.sort(nums);
        ans=new ArrayList<>();
        f(nums,0,new int[nums.length],0);
        return ans;
    }
    public void f(int[] nums,int i,int [] help,int size){
        if (i==nums.length){
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(help[j]);
            }
            ans.add(cur);

        }
        else{
            int j=i+1;
            while (j<nums.length && nums[i]==nums[j]){
                j++;
            }
            f(nums,j,help,size);
            for(;i<j;i++){
                help[size++]=nums[i];
                f(nums, i, help, size);
            }
        }
    }
}


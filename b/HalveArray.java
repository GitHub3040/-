import java.util.Arrays;
import java.util.PriorityQueue;

public class HalveArray {
    private static int MAX=100001;
    private static int size;

    public int halveArray(int[] nums) {
        int size=nums.length;
        PriorityQueue<Double> heap=new PriorityQueue<>((a,b)->b.compareTo(a));
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            heap.add((double)nums[i]);
        }
        sum/=2;
        int ans=0;
        for (double i = 0,cur; i < sum;i+=cur,ans++) {
            cur=heap.poll()/2;
            heap.add(cur);
        }
        return ans;
    }
}

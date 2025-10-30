import java.util.HashMap;

public class LongestWPI {
    public int longestWPI(int[] hours){
        for (int i = 0; i < hours.length; i++) {
            hours[i]= hours[i]>8 ? 1:-1;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0,ans=0;
        for (int i = 0; i < hours.length; i++) {
            sum+=hours[i];
            if (map.containsKey(sum-1)){
                ans=Math.max(ans,i-map.get(sum-1));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return sum>0 ? hours.length : ans;
    }
}

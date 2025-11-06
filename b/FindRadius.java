import javax.swing.plaf.metal.MetalTheme;
import java.util.Arrays;

public class FindRadius {
    public int findRadius(int [] houses,int[] heaters){
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int m=houses.length,n=heaters.length;
        int l=0;
        int ans=0;
        for (int i = 0; i < m; i++) {
            while (!best(heaters,houses,i,l)){
                l++;
            }
            ans=Math.max(ans,Math.abs(houses[i]-heaters[l]));
        }
        return ans;
    }
    public static boolean best(int[] heaters,int[] houses,int i,int l){
        return l==heaters.length-1 || Math.abs(houses[i]-heaters[l])<Math.abs(houses[i]-heaters[l+1]);
    }
}

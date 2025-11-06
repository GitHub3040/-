import java.util.Arrays;

public class NumRescuBoats {
    public int numRescuBoats(int[] people,int limit){
        Arrays.sort(people);
        int n=people.length;
        int l=0,r=n-1,ans=0;
        int weight=0;
        while (l<=r){
            weight=(l==r) ? people[l] : people[l]+people[r];
            if (weight>limit){
                ans+=1;
                r--;
            }else {
                ans+=1;
                r--;
                l++;
            }
        }
        return ans;
    }
}

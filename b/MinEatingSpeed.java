public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles,int h){
        int max=0,n=piles.length;
        for (int i = 0; i < n; i++) {
            max=Math.max(max,piles[i]);
        }
        int l=1,r=max;
        int ans=0;
        while (l<=r){
            int mid=(l+r)/2;
            if (check(mid,piles)<=h){
                ans=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return ans;
    }
    public static long check(int v,int [] piles){
        long ans=0;
        for (int i = 0; i < piles.length; i++) {
            ans+=(piles[i]+v-1)%v;
        }
        return ans;
    }
}

public class MinimumTime {
    public long minimumTime(int[] time,int totalTrips){
        long l=0,r=Integer.MAX_VALUE;
        int n=time.length;
        for (int i = 0; i < n; i++) {
            r=Math.min(time[i],r);
        }
        r= totalTrips*r;
        while (l<=r){
            long mid=l+(r-l)/2;
            if (check(mid,time)>=totalTrips){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return r+1;
    }
    public static long check(long mid,int[] time){
        long ans=0;
        for (int i = 0; i < time.length; i++) {
            ans+=(mid/time[i]);
        }
        return ans;
    }
}

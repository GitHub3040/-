public class MaxRunTime {
    public long maxRunTime(int n,int[] batteries){
        long l=0,r=0,m=batteries.length;
        for (int i = 0; i < m; i++) {
            r+=batteries[i];
        }
        while (l<=r){
            long mid=l+(r-l)/2;
            if (check(mid,batteries,n)){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return l-1;
    }
    public static boolean check(long mid,int[] batteries,int num){
        long sum=0;
        for (int battery:batteries) {
            sum+=Math.min(mid,battery);
        }
        return sum>=num*mid;
    }
    public long maxRunTime1(int n,int[] batteries){
        int max = 0;
        long sum = 0;
        for (int x : batteries) {
            max = Math.max(max, x);
            sum += x;
        }
        if ((long) max*n<=sum){
            return sum/n;
        }
        long l=0,r=sum;
        while (l<=r){
            long mid=l+(r-l)/2;
            if (check(mid,batteries,n)){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return l-1;
    }
}

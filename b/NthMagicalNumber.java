public class NthMagicalNumber {
    private static int mod=1000000007;
    public static int nthMagicalNumber(int n,int a,int b){
        long lcm=lcm(a,b);
        long ans=0;
        for (long l=0,r=(long)n*Math.min(a,b),mid=0;l<=r;){
            mid=(r+l)/2;
            long cnt=(mid/a+mid/b-mid/lcm);
            if (cnt>=n){
                ans=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return (int) (ans%mod);
    }
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(int a, int b) {
        return (long) (a / gcd(a, b) * b);
    }

}

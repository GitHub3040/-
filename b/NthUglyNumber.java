public class NthUglyNumber {
    public int nthUglyNumber(int n){
        int [] dp=new int[n+1];
        dp[1]=1;
        for (int i = 2,i1=1,i2=1,i3=1,a,b,c,cnt; i <= n ; i++) {
            a=dp[i1]*2;
            b=dp[i2]*3;
            c=dp[i3]*5;
            cnt=Math.min(Math.min(a,b),c);
            if (cnt==a){
                i1++;
            }
            if (cnt==b){
                i2++;
            }
            if (cnt==c){
                i3++;
            }
            dp[i]=cnt;
        }
        return dp[n];
    }
}

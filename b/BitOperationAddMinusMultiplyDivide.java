public class BitOperationAddMinusMultiplyDivide {
    public static int MIN = Integer.MIN_VALUE;

    public int divide(int dividend, int divisor) {
        if(dividend==MIN && divisor==MIN){
            return 1;
        }
        if (dividend!=MIN && divisor!=MIN){
            return div(dividend,divisor);
        }
        if (divisor==MIN){
            return 0;
        }
        if (divisor==neg(-1)){
            return Integer.MAX_VALUE;
        }
        dividend=add(dividend,divisor<0 ? neg(divisor) : divisor);
        int ans=div(dividend,divisor);
        int off=divisor>0 ? neg(1) : 1;
        return add(ans,off);
    }

    public static int div(int a,int b){
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans=0;
        for (int i = 30; i >=0 ; i--) {
            if ((x>>i)>=y){
                ans|=(1<<i);
                x=minus(x,y<<i);
            }
        }
        return a<0 ^ b<0 ? neg(ans) : ans;
    }
    public static int add(int a,int b){
        int ans=a;
        while(b!=0){
            ans=a^b;
            b=(a&b)<<1;
            a=ans;
        }
        return ans;
    }
    public static int neg(int a){
        return add(~a,1);
    }
    public static int minus(int a,int b){
        return add(a,neg(b));
    }
    public static int multipy(int a,int b){
        int ans=0;
        while (b!=0){
            if((b&1)!=0) {
                ans=add(ans,a);
            }
            b>>>=1;
            a<<=1;
        }
        return ans;
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SuperpalindromeInRange {
    public static int  superpalindromeInRange(String left,String right){
        long r=Long.valueOf(right);
        long l=Long.valueOf(left);
        long limit = (long) Math.sqrt((double) r);
        int ans=0;
        long num=0;
        long i=1;
        List<Long> arr=new ArrayList<>();
        do {
            num=odd(i);
            if (check(num*num,l,r)){
                ans++;
                arr.add(num*num);
            }
            num=jinum(i);
            if (check(num*num,l,r)){
                ans++;
                arr.add(num*num);
            }
            i++;
        }while (num<limit);
        Collections.sort(arr);
        for(Long a:arr){
            System.out.println(a+"L");
        }


        return ans;
    }

    private static boolean check(long l, long l1, long r) {
        return l>=l1 && l<=r && ispalindrome(l);
    }

    public static long jinum(long i){
        long ans=i;
        i/=10;
        while (i!=0){
            ans=ans*10+i%10;
            i/=10;
        }
        return ans;
    }
    public static long odd(long i){
        long ans=i;
        while (i!=0){
            ans=ans*10+i%10;
            i/=10;
        }
        return ans;
    }
    public static boolean ispalindrome(long l){
        long off=1;
        while (l/10>=off){
            off*=10;
        }
        while (l!=0){
            if (l%10!=l/off){
                return false;
            }
            l=(l%off)/10;
            off/=100;
        }
        return true;
    }
    public static void main(String [] args){
        int ans= superpalindromeInRange(String.valueOf(0),String.valueOf(Long.MAX_VALUE));
        System.out.println(ans);
    }
}

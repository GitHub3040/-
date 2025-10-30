public class GetMaxWithoutJudge {
    public static int flip(int n){
        return n^1;
    }
    public static int sign(int n){
        return flip(n>>>31);
    }
    public int getMax(int a,int b){
        int c=a-b;
        int sa=sign(a);
        int sb=sign(b);
        int sc=sign(c);
        int diffAB=sa^sb;
        int sameAB=flip(diffAB);
        int returnAB=a*sc+b*flip(c);
        return c*sameAB+diffAB*returnAB;

    }
}

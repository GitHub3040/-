public class DailyTemperatures {
    public static int [] dailyTemperatures(int[] temperatures){
        int n=temperatures.length;
        int [] stack=new int[n],ans=new int[n];
        int r=0;
        for (int i = 0; i < n; i++) {
            while (r>0 && temperatures[stack[r-1]]<temperatures[i]){
                int c=stack[--r];
                ans[c]=i-c;
            }
            stack[r++]=i;
        }
        return ans;
    }
    public static void main(String [] args){
        int[] ans={73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(ans));
    }
}

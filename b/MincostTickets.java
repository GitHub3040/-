import java.util.Arrays;

public class MincostTickets {
    private static int[] last=new int[]{1,7,30};
    public int mincostTickets(int[] days,int[] costs){
        int n=days.length;
        int [] dp=new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=-1;
        }
        return dfs(0,days,costs,dp);
    }
    public static int dfs(int i,int[] days,int[] costs,int[] dp){
        if (i==days.length){
            return 0;
        }
        if (dp[i]!=-1){
            return dp[i];
        }
        int ans=Integer.MAX_VALUE,n=days.length;
        for (int j = 0,k=i; j < 3; j++) {
            while (k<n && days[k]<days[i]+last[j]){
                k++;
            }
            ans=Math.min(ans,dfs(k,days,costs,dp)+costs[j]);
        }
        dp[i]=ans;
        return ans;
    }
    public int mincostTickets1(int[] days,int[] costs){
        int n=days.length;
        int [] dp=new int[n+1];
        Arrays.fill(dp,0,n+1,Integer.MAX_VALUE);
        dp[n]=0;
        for (int i = n-1; i >=0; i--) {
            for (int j = 0,k=i; j < 3; j++) {
                while (k<n && days[k]<days[i]+last[j]){
                    k++;
                }
                dp[i]=Math.min(dp[i],dp[k]+costs[j]);
            }
        }
        return dp[0];
    }
}

import java.util.ArrayList;

public class MinimumTime {
    public int minimumTime3(int n,int[][] relations,int[] time){
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for (int i = 0; i < relations.length; i++) {
            int u=relations[i][0]-1;
            int v=relations[i][1]-1;
            graph.get(u).add(v);
            indegree[v]++;
        }
        int [] queue=new int[n];
        int l=0,r=0;
        for (int i = 0; i < n; i++) {
            if (indegree[i]==0){
                queue[r++]=i;
            }
        }
        int [] finish=new int[n];
        while (r>l){
            int cur=queue[l++];
            finish[cur]+=time[cur];
            for (int v:graph.get(cur)){
                if (--indegree[v]==0){
                    queue[r++]=v;
                }
                finish[v]=Math.max(finish[v],finish[cur]);
            }
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans=Math.max(finish[i],ans);
        }
        return ans;
    }

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

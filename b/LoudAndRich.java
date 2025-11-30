import java.util.ArrayList;

public class LoudAndRich {
    public int[] loudAndRich(int[][] richer,int[] quiet){
        int n=quiet.length;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for (int i = 0; i < richer.length; i++) {
            int u=richer[i][0];
            int v=richer[i][1];
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
        int[] ans=new int[n];
        for (int i = 0; i < n; i++) {
            ans[i]=i;
        }
        while (r>l){
            int cur=queue[l++];
            for (int v:graph.get(cur)){
                if (--indegree[v]==0){
                    queue[r++]=v;
                }
                if (quiet[ans[cur]]<quiet[ans[v]]){
                    ans[v]=ans[cur];
                }
            }
        }
        return ans;
    }
}

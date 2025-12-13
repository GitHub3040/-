import java.util.ArrayList;
import java.util.Arrays;

public class MovesToStamp {
    public int[] movesToStamp(String stamp,String target){
        char[] stamps=stamp.toCharArray();
        char[] targets=target.toCharArray();
        int m=targets.length;
        int n=stamps.length;
        int len=m-n+1;
        int [] ans=new int[len];
        int [] indegree=new int[len];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int [] queue=new int[len];
        boolean[] visited = new boolean[m];
        int r=0,l=0;
        int c=0;
        Arrays.fill(indegree,n);
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                if (stamps[j]==targets[i+j]){
                    indegree[i]--;
                    if (indegree[i]==0){
                        queue[r++]=i;
                    }
                }else {
                    graph.get(i+j).add(i);
                }
            }
        }
        while (r>l){
            int i=queue[l++];
            ans[c++]=i;
            for (int j = 0; j < n; j++) {
                if (!visited[i+j]){
                    visited[i+j]=true;
                    for (int next : graph.get(j + i)) {
                        if (--indegree[next] == 0) {
                            queue[r++] = next;
                        }
                    }

                }
            }
        }
        if (c!=len){
            return new int[0];
        }
        for (int i=0,j=len-1;j>i;i++,j--){
            int tmp=ans[i];
            ans[i]=ans[j];
            ans[j]=tmp;
        }
        return ans;
    }
}

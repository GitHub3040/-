import config.Node;

import java.util.Arrays;

public class FindOrder {
    private static int MAXN=2002;
    private static int MAXM=4000002;
    private static int[] head=new int[MAXN];
    private static int[] next=new int[MAXM];
    private static int[] to=new int[MAXM];
    private static int cnt;


    public static void build(int n){
        Arrays.fill(head,1,n+1,0);
        cnt=1;
    }

    public static void addEdge(int u,int v){
        next[cnt]=head[u];
        to[cnt]=v;
        head[u]=cnt++;
    }

    public int[] findOrder(int numCourses,int[][] prerequisites){
        build(numCourses);
        int [] indegree=new int[numCourses+1];
        for(int [] e:prerequisites){
            addEdge(e[1]+1,e[0]+1);
            indegree[e[0]+1]++;
        }
        int[] queue=new int[numCourses];
        int r=0,l=0;
        for (int i = 1; i <= numCourses; i++) {
            if (indegree[i]==0){
                queue[r++]=i;
            }
        }
        if (r==l){
            return new int[] {};
        }
        int cnt=0;
        int [] ans=new int[numCourses];
        while (r>l){
            int node=queue[l++];
            ans[cnt++]=node-1;
            for (int ei=head[node];ei>0;ei=next[ei]){
                if (--indegree[to[ei]]==0){
                    queue[r++]=to[ei];
                }
            }
        }
        return cnt==numCourses ? ans : new int[]{};
    }
}

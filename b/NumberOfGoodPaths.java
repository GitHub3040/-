import java.util.Arrays;

public class NumberOfGoodPaths {
    private static int MAXN=30001;
    private static int[] father=new int[MAXN];
    private static int[] maxSize=new int[MAXN];
    public static void build(int n){
        for (int i = 0; i < n; i++) {
            father[i]=i;
            maxSize[i]=1;
        }
    }
    public static int find(int x){
        if (father[x]!=x){
            father[x]=find(father[x]);
        }
        return father[x];
    }
    public static int  union(int x,int y,int[] vals){
        int fx=find(x);
        int fy=find(y);
        int path=0;
        if (fx!=fy){
            if (vals[fx]>vals[fy]){
                father[fy]=fx;
            } else if (vals[fx]<vals[fy]) {
                father[fx]=fy;
            }else {
                father[fy]=fx;
                path+=maxSize[fx]*maxSize[fy];
                maxSize[fx]+=maxSize[fy];
            }
        }
        return path;
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n=vals.length;
        build(n);
        int ans=n;
        Arrays.sort(edges,(e1,e2)-> (Math.max(vals[e1[0]],vals[e1[1]]))-Math.max(vals[e2[0]],vals[e2[1]]));
        for (int i = 0; i < edges.length; i++) {
            ans+=union(edges[i][0],edges[i][1],vals);
        }
        return ans;
    }
}

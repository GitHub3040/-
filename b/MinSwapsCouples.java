public class MinSwapsCouples {
    private static int MAXN=100;
    private static int[] father=new int[MAXN];
    private static int[] size=new int[MAXN];
    private static int n;
    private static int cnt;
    public int minSwapsCouple(int[] row){
        n=row.length;
        build();
        for (int i = 0; i < n ; i+=2) {
            union(row[i],row[i+1]);
        }
        return cnt;
    }

    public static void build() {
        for (int i = 0; i <= n; i+=2) {
            father[i] = i;
            father[i+1]=i;
            size[i] = 1;
        }
        cnt=0;
    }

    public static int findFa(int x){
        if (father[x]!=x){
            father[x]=findFa(father[x]);
        }
        return father[x];
    }

    public static void union(int x,int y){
        int fx=findFa(x);
        int fy=findFa(y);
        if (fx!=fy){
            if (size[fx]>size[fy]){
                father[fy]=fx;
                size[fx]+=size[fy];
            }else {
                father[fx]=fy;
                size[fy]+=size[fx];
            }
            cnt++;
        }
    }
}

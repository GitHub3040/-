public class NumSimilarGroup {
    private static int MAXN=301;
    private static int[] father=new int[MAXN];
    private static int[] size=new int[MAXN];
    private static int n;
    private static int sets;
    public static void build(){
        for (int i = 0; i < n; i++) {
            father[i]=i;
            size[i]=1;
        }
        sets=n;
    }

    public static int find(int x){
        if (father[x]!=x){
            father[x]=find(father[x]);
        }
        return father[x];
    }

    public static void union(int x,int y){
        int fx=find(x);
        int fy=find(y);
        if (fx!=fy){
            if (size[fx]>size[fy]){
                father[fy]=x;
                size[fx]+=size[fy];
            }else {
                father[fx]=y;
                size[fy]+=size[fx];
            }
            sets--;
        }
    }
    public int numSimilarGroups(String [] strs){
        n=strs.length;
        int m=strs[0].length();
        build();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (find(i) != find(j)){
                    int diff = 0;
                    for (int k = 0; k < m && diff < 3; k++) {
                        if (strs[i].charAt(k) != strs[j].charAt(k)) {
                            diff++;
                        }
                    }
                    if (diff == 0 || diff == 2) {
                        union(i, j);
                    }
                }
            }
        }
        return sets;
    }


}

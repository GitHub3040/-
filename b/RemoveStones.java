import java.util.Arrays;
import java.util.HashMap;

public class RemoveStones {
    private static int MAXN=1001;
    private static int[] father=new int[MAXN];
    private static int cnts;
    private static int n;
    public static HashMap<Integer, Integer> rowFirst = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> colFirst = new HashMap<Integer, Integer>();
    public static void build(){
        rowFirst.clear();
        colFirst.clear();
        for (int i = 0; i < n; i++) {
            father[i]=i;
        }
        cnts=n;
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
            father[fy]=fx;
            cnts--;
        }
    }
    public int removeStones(int[][] stones){
        n=stones.length;
        build();
        for (int i = 0; i < n; i++) {
            int row=stones[i][0];
            int col=stones[i][1];
            if (!rowFirst.containsKey(row)){
                rowFirst.put(row,i);
            }else {
                union(i,rowFirst.get(row));
            }
            if (!colFirst.containsKey(col)){
                colFirst.put(col,i);
            }else {
                union(i,colFirst.get(col));
            }
        }
        return n-cnts;
    }
}

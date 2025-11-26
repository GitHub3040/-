import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllpeople {
    private static  int MAXN=100001;
    private static int[] father=new int[MAXN];
    private static boolean[] secret=new boolean[MAXN];
    public static void build(int firstPerson,int n){
        for (int i = 0; i < n; i++) {
            father[i]=i;
            secret[i]=false;
        }
        father[firstPerson]=0;
        secret[0]=true;
    }
    private static int find(int x){
        if(father[x]!=x){
            father[x]=find(father[x]);
        }
        return father[x];
    }
    private static void union(int x,int y){
        int fx=find(x);
        int fy=find(y);
        if (fx!=fy){
            father[fy]=fx;
            secret[fx]|=secret[fy];
        }
    }
    public List<Integer> findAllPeople(int n,int[][] meeting,int firstPerson){
        Arrays.sort(meeting,(a,b)-> a[2]-b[2]);
        build(firstPerson,n);
        int m=meeting.length;
        for (int i = 0,j; i < m;) {
            j=i;
            while (j<m-1 && meeting[j][2]==meeting[j+1][2]){
                j++;
            }
            for (int k = i; k<=j; k++) {
                union(meeting[k][0], meeting[k][1]);
            }
            for (int k = i; k <= j; k++) {
                int a = meeting[k][0];
                int b = meeting[k][1];
                if (!secret[find(a)]) {
                    father[a] = a;
                }
                if (!secret[find(b)]) {
                    father[b] = b;
                }
            }
            i=j+1;
        }
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secret[find(i)]){
                ans.add(i);
            }
        }
        return ans;
    }
}
